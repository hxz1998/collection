/**
 * Summer
 *
 * @Description: 当尝试附着到当前虚拟机时，抛出该异常
 * @Author: cherry
 * @Create on: 2022/6/24
 **/
package org.summer.core.exception;

public class AttachCurrentVMException extends Exception {
    public AttachCurrentVMException() {
        super("不能连接到当前虚拟机！");
    }
}
