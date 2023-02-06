/**
 * explore
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/10/1
 **/
package com.example.explore.beans;

import com.example.explore.metrics.HelloMetrics;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MetricsBean {
    @Bean
    public HelloMetrics helloMetrics() {
        return new HelloMetrics();
    }
}
