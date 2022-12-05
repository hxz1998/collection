/**
 * Summer
 *
 * @Description: 信息类的抽象接口
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor;

import org.summer.core.exception.ObjectOrListException;

import javax.management.ObjectName;

public interface Information<T> {

    /**
     * 根据名字获取对应的 MXBean
     *
     * @param name MXBean 的名字
     * @return MXBean 对象
     */
    default T find(String name) {
        throw new UnsupportedOperationException(ObjectOrListException.IS_OBJECT.toString());
    }

    /**
     * 获取 ObjectName，从而获取更细微的信息
     *
     * @return ObjectName 对象
     */
    default ObjectName getObjectName() {
        throw new UnsupportedOperationException(ObjectOrListException.IS_LIST.toString());
    }
}
