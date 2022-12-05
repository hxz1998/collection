/**
 * Summer
 *
 * @Description: 类注册接口
 * 当扫描到的类时，向该接口中注册
 * 在后面使用时，可以直接根据类名提供字节码
 * @Author: cherry
 * @Create on: 2022/6/25
 **/
package org.summer.core.modifier;

import javassist.CtClass;
import org.summer.core.exception.UndefinedException;

public interface ClassRepository {

    /**
     * 检查一个类是否存在于类仓库中
     *
     * @param name 类的全限定名
     * @return 存在与否
     */
    boolean exists(String name);

    /**
     * 检查一个类是否存在于类仓库中
     *
     * @param ctClass 类的 CtClass 对象
     * @return 存在与否
     */
    boolean exists(CtClass ctClass);

    /**
     * 检查一个类是否存在于类仓库中
     *
     * @param clazz 类的对象
     * @return 存在与否
     */
    default boolean exists(Class<?> clazz) throws UndefinedException {
        throw new UndefinedException();
    }

    /**
     * 注册一个类到类仓库中
     *
     * @param name    类的全限定名
     * @param ctClass 类的 CtClass 对象
     */
    void put(String name, CtClass ctClass, byte[] bytecode);

    void remove(String name);

    /**
     * 从仓库中获取一个类
     *
     * @param name 类的全限定名
     * @return 类的 CtClass 对象
     */
    CtClass getCtClass(String name);

    /**
     * 获取类的字节数组
     *
     * @param name 类的全限定名
     * @return 类的字节数组表示
     */
    byte[] getBytes(String name);


    Class<?> getClazz(String name);

    void put(String name, Class<?> clazz);
}
