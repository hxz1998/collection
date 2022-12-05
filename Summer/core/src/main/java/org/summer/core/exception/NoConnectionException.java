/**
 * Summer
 *
 * @Description: 未连接错误
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.exception;

public class NoConnectionException extends Exception {

    public NoConnectionException() {
        super("未连接错误！");
    }
}
