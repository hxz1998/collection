/**
 * Summer
 *
 * @Description: 虚拟机不支持时抛出的异常
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.exception;

public class VirtualMachineUnsupported extends Exception {
    public VirtualMachineUnsupported() {
        super("当前虚拟机不支持！");
    }
}
