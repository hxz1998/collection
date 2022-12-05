/**
 * Summer
 *
 * @Description: 创建文件出现问题时，抛出的异常
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.exception;

public class MakeDirException extends RuntimeException {
    public MakeDirException() {
        super("创建文件目录失败");
    }

    public MakeDirException(String dir) {
        super("创建文件目录 " + dir + " 失败！");
    }
}
