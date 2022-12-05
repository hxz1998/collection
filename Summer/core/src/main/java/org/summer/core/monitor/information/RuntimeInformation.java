/**
 * Summer
 *
 * @Description: 获取系统运行时信息的实体类
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor.information;

import org.summer.core.monitor.Information;

import javax.management.ObjectName;
import java.lang.management.RuntimeMXBean;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RuntimeInformation implements Information<RuntimeMXBean> {
    private final RuntimeMXBean mxBean;
    private Date date = null;

    public RuntimeInformation(RuntimeMXBean mxBean) {
        this.mxBean = mxBean;
    }


    public String getName() {
        return mxBean.getName();
    }

    public String getVmVendor() {
        return mxBean.getVmVendor();
    }

    public List<String> getInputArgs() {
        return mxBean.getInputArguments();
    }

    public Map<String, String> getSystemProperties() {
        return mxBean.getSystemProperties();
    }

    public long getPid() {
        return mxBean.getPid();
    }

    public String getBootClassPath() {
        return mxBean.getBootClassPath();
    }

    public String getClassPath() {
        return mxBean.getClassPath();
    }

    public String getLibraryPath() {
        return mxBean.getLibraryPath();
    }

    public String getManagementSpecVersion() {
        return mxBean.getManagementSpecVersion();
    }

    public String getSpecName() {
        return mxBean.getSpecName();
    }

    public String getSpecVendor() {
        return mxBean.getSpecVendor();
    }

    public String getSpecVersion() {
        return mxBean.getSpecVersion();
    }

    public long getStartTime() {
        long startTime = mxBean.getStartTime();
        if (null == date) date = new Date(startTime);
        return startTime;
    }

    public Date getStartDate() {
        if (null != date) return date;
        getBootClassPath();
        return date;
    }

    public long getUpTime() {
        return mxBean.getUptime();
    }

    public String getVmName() {
        return mxBean.getVmName();
    }

    public String getVmVersion() {
        return mxBean.getVmVersion();
    }

    @Override
    public ObjectName getObjectName() {
        return mxBean.getObjectName();
    }
}
