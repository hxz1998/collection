/**
 * Summer
 *
 * @Description: 异常类中的 @UnsupportedException 所需要的枚举类型
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.exception;

public enum ObjectOrListException {
    IS_LIST("是一个列表"),
    IS_OBJECT("是一个对象");

    private final String description;

    ObjectOrListException(String desc) {
        this.description = desc;
    }

    @Override
    public String toString() {
        return description;
    }
}