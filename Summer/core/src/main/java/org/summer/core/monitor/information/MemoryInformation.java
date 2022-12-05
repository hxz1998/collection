/**
 * Summer
 *
 * @Description: 获取内存简要信息
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor.information;

import org.summer.core.monitor.Information;

import javax.management.ObjectName;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryInformation implements Information<MemoryMXBean> {
    private final MemoryMXBean mxBean;

    public MemoryInformation(MemoryMXBean mxBean) {
        this.mxBean = mxBean;
    }

    public MemoryUsage getHeapMemoryUsage() {
        return mxBean.getHeapMemoryUsage();
    }

    public MemoryUsage getNonHeapMemoryUsage() {
        return mxBean.getNonHeapMemoryUsage();
    }

    public long getHeapMax() {
        return mxBean.getHeapMemoryUsage().getMax();
    }


    public void gc() {
        mxBean.gc();
    }

    public long getHeapCommitted() {
        return mxBean.getHeapMemoryUsage().getCommitted();
    }

    public long getHeapInit() {
        return mxBean.getHeapMemoryUsage().getInit();
    }

    public long getHeapUsed() {
        return mxBean.getHeapMemoryUsage().getUsed();
    }

    public long getNonHeapMax() {
        return mxBean.getNonHeapMemoryUsage().getMax();
    }

    public long getNonHeapCommitted() {
        return mxBean.getNonHeapMemoryUsage().getCommitted();
    }

    public long getNonHeapInit() {
        return mxBean.getNonHeapMemoryUsage().getInit();
    }

    public long getNonHeapUsed() {
        return mxBean.getNonHeapMemoryUsage().getUsed();
    }

    @Override
    public ObjectName getObjectName() {
        return mxBean.getObjectName();
    }
}
