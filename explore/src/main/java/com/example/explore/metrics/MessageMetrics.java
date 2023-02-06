/**
 * explore
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/10/1
 **/
package com.example.explore.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

public class MessageMetrics implements MeterBinder {

    @Override
    public void bindTo(MeterRegistry registry) {
        int a = 0b10;
    }
}
