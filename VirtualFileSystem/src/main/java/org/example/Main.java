package org.example;

import org.vf.core.File;
import org.vf.core.VDirectory;
import org.vf.engine.SimpleVirtualFileSystemEngine;
import org.vf.engine.impl.SimpleVirtualFileSystemEngineImpl;

/**
 * Default (Template) Project
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/28
 **/
public class Main {

    public static void main(String[] args) {
        SimpleVirtualFileSystemEngine engine = new SimpleVirtualFileSystemEngineImpl();
        File file = engine.makeFile(engine.getRoot(), "新文件");
        VDirectory directory = engine.makeDirectory(engine.getRoot(), "新文件夹");
        file.write("你好🍀");
        for (int i = 0; i < 1025; ++i) {
            file.append("🍀");
        }
        System.out.println(file.read());
        System.out.println();
    }
}