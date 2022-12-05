/**
 * Summer
 *
 * @Description: 修改者接口，但是暂时没用上
 * @Author: cherry
 * @Create on: 2022/7/2
 **/
package org.summer.core.modifier;

import javassist.CtBehavior;
import javassist.CtClass;

public interface Modifier {
    void modify(Class clazz, CtClass ctClass, CtBehavior behavior, String body);
}
