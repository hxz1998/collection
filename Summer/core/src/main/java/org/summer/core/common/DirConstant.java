/**
 * Summer
 *
 * @Description: 文件目录常量
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.common;

import lombok.extern.slf4j.Slf4j;
import org.summer.core.exception.MakeDirException;

import java.io.File;

@Slf4j
public class DirConstant {
    public static final String CACHE = "./.cache/";

    static {
        File file = new File(CACHE);
        if (!file.exists()) {
            if (!file.mkdir()) {
                log.error("创建临时文件目录失败！");
                throw new MakeDirException(file.getAbsolutePath());
            }
            log.info("创建缓存目录成功：" + file.getAbsolutePath());
        }

    }
}
