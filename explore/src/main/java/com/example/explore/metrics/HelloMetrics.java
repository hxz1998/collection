/**
 * explore
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/10/1
 **/
package com.example.explore.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloMetrics implements MeterBinder {
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        Gauge.builder("demo.count", count, AtomicInteger::incrementAndGet)
                .tag("host", "localhost")
                .description("demo of custom meter binder")
                .register(meterRegistry);
    }
}
