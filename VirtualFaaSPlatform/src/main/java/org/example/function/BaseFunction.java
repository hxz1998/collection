/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/5
 **/
package org.example.function;

public interface BaseFunction<R, T> {

    R invoke(T params);
}
