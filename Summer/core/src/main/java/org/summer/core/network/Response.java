/**
 * Summer
 *
 * @Description: 响应实体类，封装了响应的结果
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.network;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response<T> {
    private String msg;
    private T value;
    private ResponseType type;

    public Response(String msg, T value, ResponseType type) {
        this.msg = msg;
        this.value = value;
        this.type = type;
    }

    public Response() {

    }
}
