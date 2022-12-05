/**
 * Summer
 *
 * @Description: 反编译器具体实现
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.compiler.hotspot;

import lombok.extern.slf4j.Slf4j;
import org.jboss.windup.decompiler.api.DecompilationException;
import org.jboss.windup.decompiler.api.DecompilationFailure;
import org.jboss.windup.decompiler.api.DecompilationListener;
import org.jboss.windup.decompiler.api.DecompilationResult;
import org.jboss.windup.decompiler.fernflower.FernFlowerResultSaver;
import org.jboss.windup.decompiler.fernflower.FernflowerDecompiler;
import org.jboss.windup.decompiler.fernflower.FernflowerJDKLogger;
import org.jboss.windup.util.exception.WindupStopException;
import org.jetbrains.java.decompiler.main.Fernflower;
import org.jetbrains.java.decompiler.main.extern.IBytecodeProvider;
import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences;
import org.jetbrains.java.decompiler.util.InterpreterUtil;
import org.summer.core.common.DirConstant;
import org.summer.core.compiler.Decompiler;
import org.summer.core.exception.MakeDirException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
public class DecompilerImpl extends FernflowerDecompiler implements Decompiler {
    private static final Map<String, Object> options = new HashMap<>();
    private static final String TEMPORARY_DIR = DirConstant.CACHE + "decompile/";

    // 反编译选项，临时文件创建
    static {
        options.put(IFernflowerPreferences.REMOVE_BRIDGE, "0");
        options.put(IFernflowerPreferences.LAMBDA_TO_ANONYMOUS_CLASS, "1");
        options.put(IFernflowerPreferences.BYTECODE_SOURCE_MAPPING, "1");
        File TEMPORARY_PATH = new File(TEMPORARY_DIR);
        if (!TEMPORARY_PATH.exists()) {
            if (!TEMPORARY_PATH.mkdirs()) {
                log.error("创建反编译临时文件目录出错");
                throw new MakeDirException(TEMPORARY_PATH.getAbsolutePath());
            }
        }
    }

    public DecompilationResult decompileClassFile(Path classFilePath, Path outputDir) {
        return decompileClassFile(null, classFilePath, outputDir);
    }

    @Override
    public DecompilationResult decompileClassFile(Path rootDir, Path classFilePath, Path outputDir) throws DecompilationException {
        final DecompilationResult result = new DecompilationResult();
        DecompilationListener listener = new DecompilationListener() {
            private boolean cancelled;

            @Override
            public void fileDecompiled(List<String> inputPath, String outputPath) {
                try {
                    result.addDecompiled(inputPath, outputPath);
                } catch (WindupStopException stop) {
                    this.cancelled = true;
                    throw new WindupStopException(stop);
                }
            }

            @Override
            public void decompilationFailed(List<String> inputPath, String message) {
                result.addFailure(new DecompilationFailure(message, inputPath, null));
            }

            @Override
            public void decompilationProcessComplete() {

            }

            @Override
            public boolean isCancelled() {
                return this.cancelled;
            }
        };

        FernFlowerResultSaver resultSaver = getResultSaver(Collections.singletonList(classFilePath.toString()), outputDir.toFile(), listener);
        Fernflower fernflower = new Fernflower(getByteCodeProvider(), resultSaver, options, new FernflowerJDKLogger());
        fernflower.getStructContext().addSpace(classFilePath.toFile(), true);
        fernflower.decompileContext();

        if (!resultSaver.isFileSaved())
            listener.decompilationFailed(Collections.singletonList(classFilePath.toString()), "File was not decompiled!");

        return result;
    }

    private FernFlowerResultSaver getResultSaver(final List<String> requests, File directory, final DecompilationListener listener) {
        return new FernFlowerResultSaver(requests, directory, listener);
    }

    private IBytecodeProvider getByteCodeProvider() {
        return (externalPath, internalPath) -> InterpreterUtil.getBytes(new File(externalPath));
    }

    @Override
    public String decompile(byte[] bytecode) {
        return decompile(UUID.randomUUID().toString(), bytecode);
    }

    @Override
    public String decompile(String filename, byte[] bytecode) {
        String classFilename = TEMPORARY_DIR + filename + ".class";
        File file = new File(classFilename);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.write(bytecode);
            return decompile(filename, file);
        } catch (IOException ex) {
            log.error("反编译出错了");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String decompile(String classFile) {
        return null;
    }

    @Override
    public String decompile(String filename, File classFile) {
        String javaFilename = TEMPORARY_DIR + filename + ".java";
        DecompilationResult result = decompileClassFile(Paths.get(classFile.getAbsolutePath()), Paths.get(javaFilename));
        if (result.getFailures().size() > 0) {
            log.error("反编译出错了，结果如下：");
            for (DecompilationFailure failure : result.getFailures()) {
                log.error(failure.getMessage());
            }
        }
        Map<String, String> decompiles = result.getDecompiledFiles();
        File javaFile = new File(decompiles.values().iterator().next());
        StringBuilder code = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(javaFile)))) {
            String line;
            while ((line = br.readLine()) != null) {
                code.append(line);
                code.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            classFile.deleteOnExit();
            javaFile.deleteOnExit();
        }
        return code.toString();
    }
}
