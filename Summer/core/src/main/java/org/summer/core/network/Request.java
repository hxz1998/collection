/**
 * Summer
 *
 * @Description: 可序列化
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.network;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Request<T> implements Serializable {
    private RequestType type;
    private T value;

    public Request() {
    }

    public Request(RequestType requestType, T value) {
        this.type = requestType;
        this.value = value;
    }
}
