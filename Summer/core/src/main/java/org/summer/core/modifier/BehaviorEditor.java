/**
 * Summer
 *
 * @Description: 行为修改接口
 * 定义了修改一个方法所提供的接口
 * @Author: cherry
 * @Create on: 2022/6/25
 **/
package org.summer.core.modifier;

import javassist.*;

public interface BehaviorEditor {

    /**
     * 修改一个方法体，不管是构造函数还是成员函数或者是静态函数
     * 该方法主要解决 CtClass ”冰冻“ 问题
     * @param ctClass  类的 CtClass 对象
     * @param behavior 方法的对象
     * @param code     将要修改的程序
     */
    void edit(CtClass ctClass, CtBehavior behavior, String code) throws CannotCompileException;

    /**
     * 修改一个方法体，不管是构造函数还是成员函数或者是静态函数
     *
     * @param behavior 方法的对象
     * @param code     将要修改的程序
     */
    void edit(CtBehavior behavior, String code) throws CannotCompileException;

    /**
     * 修改一个构造方法的方法体
     *
     * @param constructor 方法的对象
     * @param code        将要修改的程序
     */
    void edit(CtConstructor constructor, String code) throws CannotCompileException;

    /**
     * 修改一个成员或者静态方法的方法体
     *
     * @param ctMethod 方法的对象
     * @param code     将要修改的程序
     */
    void edit(CtMethod ctMethod, String code) throws CannotCompileException;

}
