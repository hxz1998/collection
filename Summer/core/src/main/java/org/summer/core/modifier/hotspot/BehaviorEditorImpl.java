/**
 * Summer
 *
 * @Description: 具体修改工具的实现类
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.modifier.hotspot;

import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.modifier.BehaviorEditor;

@Slf4j
public class BehaviorEditorImpl implements BehaviorEditor {

    @Override
    public void edit(CtClass ctClass, CtBehavior behavior, String code) throws CannotCompileException {
        if (ctClass.isFrozen()) ctClass.defrost();
        edit(behavior, code);
    }

    @Override
    public void edit(CtBehavior behavior, String code) throws CannotCompileException {
        log.debug("准备修改 " + behavior.getName() + " 方法");
        ExprEditor editor = new ExprEditor() {
            @Override
            public void edit(MethodCall m) throws CannotCompileException {
                m.replace(code);
            }
        };
        behavior.instrument(editor);
    }

    @Override
    public void edit(CtConstructor constructor, String code) throws CannotCompileException {
        edit((CtBehavior) constructor, code);
    }

    @Override
    public void edit(CtMethod ctMethod, String code) throws CannotCompileException {
        edit((CtBehavior) ctMethod, code);
    }
}
