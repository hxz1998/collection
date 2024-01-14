/**
 * quartz-demo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/1/14
 **/
package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class QuartzConfig {

    @Value("${biz.task}")
    private String task;

}
