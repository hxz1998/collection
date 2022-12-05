/**
 * Summer
 *
 * @Description: 对内存信息的详情进行获取
 * 对于G1收集器而言，包括如下部分
 * 1. metaSpace
 * 2. CodeHeap non-nmethods
 * 3. CodeHeap profiled nmethods
 * 4. Compressed class space
 * 5. G1 Eden Space
 * 6. G1 Old Gen
 * 7. G1 Survivor Space
 * 8. CodeHeap 'non-profiled nmethods
 *
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor.information;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.monitor.Information;

import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
public class MemoryPoolsInformation implements Information<MemoryPoolMXBean> {
    @Getter
    private final List<MemoryPoolMXBean> mxBeans;
    @Getter
    private final List<MemoryPoolMXBean> heapMXBean;
    @Getter
    private final List<MemoryPoolMXBean> nonHeapMXBean;
    private final Map<String, MemoryPoolMXBean> memoryPools;

    public MemoryPoolsInformation(List<MemoryPoolMXBean> mxBeans) {
        this.mxBeans = mxBeans;
        heapMXBean = new LinkedList<>();
        nonHeapMXBean = new LinkedList<>();
        memoryPools = new HashMap<>();
        initialization();
    }

    public MemoryUsage getPeakUsage(MemoryPoolMXBean target) {
        return target.getPeakUsage();
    }

    public MemoryUsage getUsage(MemoryPoolMXBean target) {
        return target.getUsage();
    }

    public String[] getMemoryManagerNames(MemoryPoolMXBean target) {
        return target.getMemoryManagerNames();
    }

    public void resetPeakUsage(MemoryPoolMXBean target) {
        target.resetPeakUsage();
    }

    @Override
    public MemoryPoolMXBean find(String name) {
        return memoryPools.get(name);
    }

    private void initialization() {
        for (MemoryPoolMXBean memoryPoolMXBean : mxBeans) {
            if (memoryPoolMXBean.getType() == MemoryType.HEAP) heapMXBean.add(memoryPoolMXBean);
            else if (memoryPoolMXBean.getType() == MemoryType.NON_HEAP) nonHeapMXBean.add(memoryPoolMXBean);
            memoryPools.put(memoryPoolMXBean.getName(), memoryPoolMXBean);
        }
    }

    public MemoryPoolMXBean getMetaSpaceMXBean() {
        return getMxBeans().get(0);
    }

    public MemoryPoolMXBean getG1EdenMXBean() {
        return getMxBeans().get(4);
    }

    public MemoryPoolMXBean getG1OldMXBean() {
        return getMxBeans().get(5);
    }

    public MemoryPoolMXBean getG1SurvivorMXBean() {
        return getMxBeans().get(6);
    }
}
