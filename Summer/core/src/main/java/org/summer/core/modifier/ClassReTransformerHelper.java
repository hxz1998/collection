/**
 * Summer
 *
 * @Description: 类型重新转换的帮助实现类，但是暂时没用上
 * @Author: cherry
 * @Create on: 2022/7/2
 **/
package org.summer.core.modifier;

import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class ClassReTransformerHelper implements ClassFileTransformer {
    private final String code;
    private final CtBehavior behavior;
    private final String className;
    private final CtClass ctClass;

    public ClassReTransformerHelper(String className, String code, CtBehavior behavior, CtClass ctClass) {
        this.className = className;
        this.code = code;
        this.behavior = behavior;
        this.ctClass = ctClass;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals(this.className)) return null;
        ExprEditor editor = new ExprEditor() {
            @Override
            public void edit(MethodCall m) throws CannotCompileException {
                m.replace(code);
            }
        };
        try {
            behavior.instrument(editor);
        } catch (CannotCompileException e) {
            throw new RuntimeException(e);
        }
        try {
            return ctClass.toBytecode();
        } catch (IOException | CannotCompileException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.code.equals(((ClassReTransformerHelper) obj).code);
    }
}
