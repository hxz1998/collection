/**
 * Summer
 *
 * @Description: 实际可以获取虚拟机信息的类
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.monitor;

import com.sun.tools.attach.VirtualMachine;
import org.summer.core.common.MXBeanType;
import org.summer.core.exception.UndefinedException;
import org.summer.core.exception.VirtualMachineUnsupported;
import org.summer.core.util.MXBeanFactoryImpl;

import java.util.List;

public interface Provider {

    /**
     * 把虚拟机和监视器数据进行连接
     * 并保存对应的 MXBean 对象
     *
     * @param vmd 虚拟机对象
     * @see org.summer.core.util.VirtualMachineHelper
     * @see MXBeanFactoryImpl
     */
    default void inject(VirtualMachine vmd) throws VirtualMachineUnsupported {
        throw new VirtualMachineUnsupported();
    }

    /**
     * 列举当前数据提供者可以提供哪些数据对象
     *
     * @return 描述当前 MXBean 对象的列表
     * @see org.summer.core.common.MXBeanType
     */
    List<MXBeanType> list();

    /**
     * 获取指定类型的 MXBean
     * 并不好用，推荐使用 MXBeanFactory 获取
     *
     * @param type 指定的类型
     * @param <T>  用于类型转换的类型
     * @return 找到的 MXBean对象
     * @see MXBeanFactoryImpl
     */
    default <T> T get(MXBeanType type, Class<T> clazz) throws UndefinedException {
        throw new UndefinedException();
    }
}
