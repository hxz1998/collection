/**
 * Summer
 *
 * @Description: 类视图接口
 * 提供了类名获取类反编译结果的接口
 * @Author: cherry
 * @Create on: 2022/6/25
 **/
package org.summer.core.modifier;

import javassist.CtBehavior;
import javassist.CtClass;

public interface ClassViewer {
    String getString(CtClass ctClass);

    String getString(String name);

    String getString(byte[] bytes);

    CtBehavior[] getBehaviors(CtClass ctClass);

    CtBehavior[] getBehaviors(String name);
}
