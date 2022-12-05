/**
 * Summer
 *
 * @Description: 对垃圾收集状况进行获取
 * 对于G1收集器而言，分为老年代和年轻代两个部分
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor.information;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.monitor.Information;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GarbageCollectorsInformation implements Information<GarbageCollectorMXBean> {
    @Getter
    private final List<GarbageCollectorMXBean> garbageCollectors;
    private final Map<String, GarbageCollectorMXBean> beans;
    private final List<String> gcNames;

    public GarbageCollectorsInformation(List<GarbageCollectorMXBean> garbageCollectorMXBeans) {
        this.garbageCollectors = garbageCollectorMXBeans;
        beans = new HashMap<>();
        gcNames = new ArrayList<>();
        initialization();
    }

    public String getName(GarbageCollectorMXBean target) {
        return target.getName();
    }

    public long getCollectionTime(GarbageCollectorMXBean target) {
        return target.getCollectionTime();
    }

    public long getCollectionCount(GarbageCollectorMXBean target) {
        return target.getCollectionCount();
    }

    public List<String> collectorsList() {
        return gcNames;
    }

    @Override
    public GarbageCollectorMXBean find(String name) {
        return beans.get(name);
    }

    private void initialization() {
        for (GarbageCollectorMXBean collectors : garbageCollectors) {
            String name = collectors.getName();
            gcNames.add(name);
            beans.put(name, collectors);
        }
    }
}
