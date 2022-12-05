/**
 * Summer
 *
 * @Description: 请求类型枚举类
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.network;

public enum RequestType {
    GET_CLASS_CONTENT("get_target_class_content"),
    LIST_CLASSES("list_all_classes"),
    MODIFY("modify_class_method"),
    LIST_METHOD("list_class_methods");

    private final String desc;

    RequestType(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
