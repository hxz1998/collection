/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/5
 **/
package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class VirtualFaaSPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirtualFaaSPlatformApplication.class);
        log.info("启动成功");
    }
}
