/**
 * Summer
 *
 * @Description: 响应类型枚举类
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.network;

public enum ResponseType {
    OK("调用成功"), ERROR("调用失败");

    private final String desc;

    ResponseType(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
