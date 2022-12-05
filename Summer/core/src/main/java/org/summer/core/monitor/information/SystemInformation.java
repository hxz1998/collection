/**
 * Summer
 *
 * @Description: 获取操作系统信息
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor.information;

import org.summer.core.monitor.Information;

import javax.management.ObjectName;
import java.lang.management.OperatingSystemMXBean;

public class SystemInformation implements Information<OperatingSystemMXBean> {

    private final OperatingSystemMXBean mxBean;

    public SystemInformation(OperatingSystemMXBean mxBean) {
        this.mxBean = mxBean;
    }

    public double getSystemLoadAverage() {
        return mxBean.getSystemLoadAverage();
    }

    public String getArch() {
        return mxBean.getArch();
    }

    public int getAvailableProcessors() {
        return mxBean.getAvailableProcessors();
    }

    public String getName() {
        return mxBean.getName();
    }

    public String getVersion() {
        return mxBean.getVersion();
    }

    @Override
    public ObjectName getObjectName() {
        return mxBean.getObjectName();
    }
}
