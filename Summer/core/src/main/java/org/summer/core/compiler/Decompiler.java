/**
 * Summer
 *
 * @Description: 反编译器接口
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.compiler;

import java.io.File;

public interface Decompiler {

    String decompile(byte[] bytecode);

    String decompile(String filename, byte[] bytecode);

    String decompile(String classFile);

    String decompile(String filename, File classFile);
}
