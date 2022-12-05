/**
 * Summer
 *
 * @Description: 修改者具体实现类
 * @Author: cherry
 * @Create on: 2022/7/2
 **/
package org.summer.core.modifier.hotspot;

import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.modifier.BehaviorEditor;
import org.summer.core.modifier.ClassReTransformerHelper;
import org.summer.core.modifier.Modifier;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

@Slf4j
public class ModifierImpl implements Modifier {
    private final BehaviorEditor behaviorEditor;
    private final Instrumentation instrumentation;

    public ModifierImpl(BehaviorEditor behaviorEditor, Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
        this.behaviorEditor = behaviorEditor;
    }

    @Override
    public void modify(Class clazz, CtClass ctClass, CtBehavior behavior, String body) {
        try {
            behaviorEditor.edit(ctClass, behavior, body);
        } catch (CannotCompileException e) {
            log.error("增强 " + ctClass.getName() + " 的 " + behavior.getName() + " 失败！");
            throw new RuntimeException(e);
        }
        ClassReTransformerHelper helper = new ClassReTransformerHelper(ctClass.getName(), body, behavior, ctClass);
        instrumentation.addTransformer(helper, true);
        try {
            instrumentation.retransformClasses(clazz);
        } catch (UnmodifiableClassException e) {
            log.error("重新转换 " + clazz.getName() + " 失败！");
            throw new RuntimeException(e);
        }
        instrumentation.removeTransformer(helper);
    }
}
