/**
 * Summer
 *
 * @Description: 类视图实现类
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.modifier.hotspot;

import javassist.CtBehavior;
import javassist.CtClass;
import org.summer.core.compiler.Decompiler;
import org.summer.core.compiler.hotspot.DecompilerImpl;
import org.summer.core.modifier.ClassRepository;
import org.summer.core.modifier.ClassViewer;

public class ClassViewerImpl implements ClassViewer {

    private final Decompiler decompiler;
    private final ClassRepository classRepository;

    public ClassViewerImpl() {
        this.decompiler = new DecompilerImpl();
        this.classRepository = new ClassRepositoryImpl();
    }


    public ClassViewerImpl(Decompiler decompiler, ClassRepository classRepository) {
        this.decompiler = decompiler;
        this.classRepository = classRepository;
    }

    @Override
    public String getString(CtClass ctClass) {
        return decompiler.decompile(classRepository.getBytes(ctClass.getName()));
    }

    @Override
    public String getString(String name) {
        return decompiler.decompile(classRepository.getBytes(name));
    }

    @Override
    public String getString(byte[] bytes) {
        return decompiler.decompile(bytes);
    }

    @Override
    public CtBehavior[] getBehaviors(CtClass ctClass) {
        return ctClass.getDeclaredBehaviors();
    }

    @Override
    public CtBehavior[] getBehaviors(String name) {
        return classRepository.getCtClass(name).getDeclaredBehaviors();
    }


}
