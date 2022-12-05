/**
 * Summer
 *
 * @Description: 类扫描器接口
 * @Author: cherry
 * @Create on: 2022/6/25
 **/
package org.summer.core.modifier;

import org.summer.core.exception.UndefinedException;

import java.lang.instrument.Instrumentation;
import java.nio.file.Path;

public interface ClassScanner {
    /**
     * 列出所有加载过的类，不限来源
     *
     * @return 所有加载过的类数组
     */
    Class<?>[] listAllLoadedClass();

    /**
     * 列出所有以 prefix 为前缀加载过的类，不限来源
     *
     * @param prefix 类的前缀，一般为包名
     * @return 类对象数组
     */
    Class<?>[] listAllLoadedClass(String prefix);

    /**
     * 列出当前虚拟机所加载的所有类
     *
     * @param instrumentation 从 Agentmain/Premain 函数处获取到的工具对象
     * @return 所有加载过的类
     */
    Class<?>[] listAllLoadedClass(Instrumentation instrumentation);

    /**
     * 列出来当前虚拟机加载过的，以 prefix 为前缀的类
     *
     * @param instrumentation 从 Agentmain/Premain 函数处获取到的工具对象
     * @param prefix          类的前缀
     * @return 所有加载过的类
     */
    Class<?>[] listAllLoadedClass(Instrumentation instrumentation, String prefix);

    /**
     * 从指定路径上递归扫描所有的类，不管加载与否
     *
     * @param root 根路径
     * @return 所有存在的类
     */
    default Class<?>[] listAll(Path root) throws UndefinedException {
        throw new UndefinedException();
    }

    /**
     * 从指定路径处扫描以 prefix 为前缀的类
     *
     * @param root   根路径
     * @param prefix 前缀
     * @return 所有类的对象
     */
    default Class<?>[] list(Path root, String prefix) throws UndefinedException {
        throw new UndefinedException();
    }
}
