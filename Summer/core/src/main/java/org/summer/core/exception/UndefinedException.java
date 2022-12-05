/**
 * Summer
 *
 * @Description: 当接口中定义了，但是具体实现类中没有实现时，抛出的异常
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.exception;

public class UndefinedException extends Exception {
    public UndefinedException() {
        super("调用了未实现的方法");
    }
}
