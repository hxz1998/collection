/**
 * Summer
 *
 * @Description: 测试反编译
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.test;

import org.summer.core.compiler.hotspot.DecompilerImpl;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestDecompilerImpl {
    public static void main(String[] args) throws IOException {
        DecompilerImpl decompiler = new DecompilerImpl();
        DataInputStream dis = new DataInputStream(new FileInputStream(new File("../../target/test-classes/org/summer/core/test/TestDecompilerImpl.class")));
        System.out.println(decompiler.decompile(dis.readAllBytes()));
    }
}
