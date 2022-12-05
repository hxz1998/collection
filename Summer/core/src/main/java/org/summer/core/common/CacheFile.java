/**
 * Summer
 *
 * @Description: 缓存文件操作类
 * @Author: cherry
 * @Create on: 2022/6/27
 **/
package org.summer.core.common;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Objects;

@Slf4j
public class CacheFile {
    public static void cacheFileDelete() {
        File file = new File(DirConstant.CACHE + "\\");
        log.debug("清空缓存文件" + file.getAbsolutePath());
        if (file.exists()) {
            delete(file);
        }
    }

    private static void delete(File file) {
        if (null == file) return;
        if (file.isDirectory()) {
            log.debug("删除 " + file.getAbsolutePath() + " 文件夹");
            for (File child : Objects.requireNonNull(file.listFiles())) {
                delete(child);
            }
            if (!file.delete()) log.info("缓存目录" + file.getAbsolutePath() + "删除失败！");
        } else if (file.isFile()) {
            log.debug("删除 " + file.getAbsolutePath() + " 文件");
            if (!file.delete()) log.info("缓存文件" + file.getAbsolutePath() + "删除失败！");
        }
    }
}
