/**
 * Summer
 *
 * @Description: 用于双方通信时提供的服务端代理
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.compiler.Decompiler;
import org.summer.core.compiler.hotspot.DecompilerImpl;
import org.summer.core.modifier.BehaviorEditor;
import org.summer.core.modifier.ClassRepository;
import org.summer.core.modifier.ClassScanner;
import org.summer.core.modifier.ClassViewer;
import org.summer.core.modifier.hotspot.ClassRepositoryImpl;
import org.summer.core.modifier.hotspot.ClassScannerImpl;
import org.summer.core.modifier.hotspot.ClassViewerImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.ProtectionDomain;
import java.util.LinkedList;

@Slf4j
public class AgentProxyServer {
    private final Thread networkThread;
    private boolean isAlive = true;

    private final ServerSocket server;

    private final Kryo serializer;

    private static Instrumentation instrumentation;
    private static ClassPool pool;

    private static ClassRepository classRepository;

    private ClassScanner classScanner;
    private ClassViewer classViewer;
    private BehaviorEditor behaviorEditor;

    private Decompiler decompiler;

    private static final ClassScannerHelperTransformer scannerHelper = new ClassScannerHelperTransformer();

    public AgentProxyServer(int port, Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
        instrumentation.addTransformer(scannerHelper, true);

        networkThread = new Thread(getProvider(), "服务器代理线程");

        serializer = new Kryo();
        serializer.register(Request.class);
        serializer.register(Response.class);
        serializer.register(RequestType.class);
        serializer.register(ResponseType.class);
        serializer.register(Class.class);
        serializer.register(LinkedList.class);
        serializer.register(ModifyEntity.class);

        decompiler = new DecompilerImpl();

        classScanner = new ClassScannerImpl(instrumentation);
        classRepository = new ClassRepositoryImpl();
        classViewer = new ClassViewerImpl(decompiler, classRepository);

        pool = ClassPool.getDefault();

        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            log.error("创建代理服务器出错！");
            throw new RuntimeException(e);
        }
        log.debug("初始化完成！");
    }

    public void start() {
        networkThread.start();
        networkThread.setPriority(Thread.MAX_PRIORITY);
    }

    void stop() {
        isAlive = false;
    }

    private Runnable getProvider() {
        return () -> {
            while (true) {
                try (Socket socket = server.accept()) {
                    log.debug("正在监听新的请求！");
                    BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                    Input input = new Input(bis);
                    BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                    Output output = new Output(bos);
                    Request request = serializer.readObject(input, Request.class);
                    log.debug("获取到请求" + request.getValue());
                    if (request.getType() == RequestType.LIST_CLASSES) {
                        Response<LinkedList<String>> response = new Response<>();
                        LinkedList<String> list = new LinkedList<>();
                        for (Class<?> clazz : instrumentation.getAllLoadedClasses()) {
                            if (clazz.getName().startsWith((String) request.getValue()) &&
                                    !clazz.getName().contains("$")) {
                                list.add(clazz.getName());
                                log.debug("尝试记录 " + clazz.getName() + " 类");
                                try {
                                    instrumentation.retransformClasses(clazz);
                                } catch (UnmodifiableClassException e) {
                                    throw new RuntimeException(e);
                                }
                                classRepository.put(clazz.getName(), clazz);
                                if (!classRepository.exists(clazz.getName())) list.removeLast();
                            }
                        }
                        response.setMsg("获取类列表完成");
                        response.setType(ResponseType.OK);
                        response.setValue(list);
                        serializer.writeObject(output, response);
                    } else if (request.getType() == RequestType.GET_CLASS_CONTENT) {
                        String className = (String) request.getValue();
                        Response<String> response = new Response<>();
                        response.setValue(classViewer.getString(classRepository.getBytes(className)));
                        if (response.getValue() != null) response.setType(ResponseType.OK);
                        else {
                            response.setType(ResponseType.ERROR);
                            response.setMsg("没找到对应的类");
                        }
                        serializer.writeObject(output, response);
                    } else if (request.getType() == RequestType.MODIFY) {
                        ModifyEntity entity = (ModifyEntity) request.getValue();
                        log.debug("正在重新修改 : " + entity.getLabel() + " ------- " + entity.getCode());
                        String[] items = entity.getLabel().split("#");
                        String className = items[0];
                        String methodName = items[1];
                        ClassTransformHelper helper = new ClassTransformHelper(entity.getCode(), className, methodName);
                        instrumentation.addTransformer(helper, true);
                        Class<?> targetClass = classRepository.getClazz(className);
                        instrumentation.retransformClasses(targetClass);
                        instrumentation.removeTransformer(helper);
                        Response<String> response = new Response<>();
                        response.setType(ResponseType.OK);
                        response.setMsg("转换完成");
                        response.setValue(entity.getLabel());
                        serializer.writeObject(output, response);
                    } else if (request.getType() == RequestType.LIST_METHOD) {
                        Response<LinkedList<String>> response = new Response<>();
                        CtClass ctClass = pool.get((String) request.getValue());
                        if (ctClass.isFrozen()) ctClass.defrost();
                        response.setMsg("获取类方法列表完成");
                        LinkedList<String> value = new LinkedList<>();
                        for (CtMethod method : ctClass.getDeclaredMethods()) {
                            if (method.getMethodInfo().toString().equals("main ([Ljava/lang/String;)V")) continue;
                            value.add(method.getMethodInfo().toString());
                        }
                        response.setValue(value);
                        response.setType(ResponseType.OK);
                        serializer.writeObject(output, response);
                    }
                    output.flush();
                    output.close();
                    input.close();
                } catch (IOException e) {
                    log.error("和客户端建立连接失败！");
                    throw new RuntimeException(e);
                } catch (NotFoundException e) {
                    log.error("找不到指定的类方法");
                    throw new RuntimeException(e);
                } catch (UnmodifiableClassException e) {
                    log.debug("修改了不能修改的类");
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private static class ClassScannerHelperTransformer implements ClassFileTransformer {
        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            pool.appendClassPath(new LoaderClassPath(loader));
            log.debug("重新转换 " + className + " 中...");
            try {
                classRepository.put(className.replace("/", "."), pool.getCtClass(className), classfileBuffer);
            } catch (NotFoundException e) {
                log.debug("类 " + className + " 可能是临时生成的，不存在");
                throw new RuntimeException(e);
            }
            return classfileBuffer;
        }
    }

    private static class ClassTransformHelper implements ClassFileTransformer {
        private final String code;
        private final String targetClassName;
        private final String methodName;

        public ClassTransformHelper(String code, String targetClassName, String methodName) {
            this.code = code;
            this.targetClassName = targetClassName;
            this.methodName = methodName;
        }

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            if (className.replace("/", ".").equals(targetClassName)) {
                // 当修改的类和目标类一致时，才会进行下面的动作
                try {
                    CtClass targetCtClass = pool.get(targetClassName);
                    if (targetCtClass.isFrozen()) targetCtClass.defrost();
                    for (CtMethod method : targetCtClass.getDeclaredMethods()) {
                        if (method.getMethodInfo().toString().equals(methodName)) {
                            ExprEditor editor = new ExprEditor() {
                                @Override
                                public void edit(MethodCall m) throws CannotCompileException {
                                    m.replace(code);
                                }
                            };
                            method.instrument(editor);
                        }
                    }
                    byte[] bytes = targetCtClass.toBytecode();
                    classRepository.put(targetClassName, targetCtClass, bytes);
                    return bytes;
                } catch (NotFoundException | IOException | CannotCompileException e) {
                    throw new RuntimeException(e);
                }
            }
            return null;
        }

    }
}
