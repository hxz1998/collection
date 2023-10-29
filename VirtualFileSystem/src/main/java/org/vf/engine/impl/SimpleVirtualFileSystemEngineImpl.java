/**
 * VirtualFileSystem
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/28
 **/
package org.vf.engine.impl;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.vf.core.File;
import org.vf.core.VDirectory;
import org.vf.core.VFile;
import org.vf.engine.SimpleVirtualFileSystemEngine;

@Slf4j
public class SimpleVirtualFileSystemEngineImpl implements SimpleVirtualFileSystemEngine {

    private static final VDirectory root = new VDirectory("/", "");

    @Override
    public void add(VDirectory directory, File file) {
        // 文件校验之类的暂不考虑
        directory.addChildren(file);
    }

    @Override
    public void delete(VDirectory directory, File file) {
        directory.deleteChildren(file);
    }

    @Override
    public VDirectory makeDirectory(VDirectory directory, String directoryName) {
        log.info("创建文件夹：{}", directoryName);
        VDirectory newDirectory = new VDirectory(directoryName, "");
        directory.addChildren(newDirectory);
        return newDirectory;
    }

    @Override
    public File makeFile(VDirectory directory, String filename) {
        File file = new VFile(filename, "");
        this.add(directory, file);
        return file;
    }

    @Override
    public VDirectory getRoot() {
        return root;
    }

    @Override
    public File getDirectory(String pathString) {
        return null;
    }

    @Override
    public File getFile(String pathString) {
        String[] path = pathString.split("/");
        File currDir = getRoot();
        for (int i = 1; i < path.length; ++i) {
            Set<File> files = currDir.getChildren();
            boolean matched = false;
            for (File file : files) {
                if (i == path.length - 1 && file.isFile() && file.getName().equals(path[i])) {
                    log.info("找到了目标文件：{}", pathString);
                    return file;
                } else if (!file.isFile() && file.getName().equals(path[i])) {
                    currDir = file;
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                log.info("没找到目标文件：{}", pathString);
                break;
            }
        }
        return null;
    }
}
