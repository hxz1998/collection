/**
 * explore
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/2
 **/
package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URL;

@Slf4j
@Component
public class Helper {
    static {
        URL url = Helper.class.getClassLoader().getResource("native-helper.dll");
        if (url == null) {
            throw new RuntimeException("没找到对应的DLL库");
        }
        System.load(url.getPath());
        log.info("加载 native-helper 成功");
    }

    private static synchronized native <T> T[] getInstances0(Class<T> klass, int limit);

    public <T> T[] getInstances(Class<T> klass) {
        return getInstances0(klass, -1);
    }
}
