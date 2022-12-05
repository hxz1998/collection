/**
 * Summer
 *
 * @Description: 获取JVM内线程的状况
 * 之后的版本会增加调用栈分析
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor.information;

import org.summer.core.exception.UndefinedException;
import org.summer.core.monitor.Information;
import org.summer.core.util.FormatStrategy;
import org.summer.core.util.ThreadInfoFormat;

import javax.management.ObjectName;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadInformation implements Information<ThreadMXBean> {
    private final ThreadMXBean mxBean;

    public ThreadInformation(ThreadMXBean mxBean) {
        this.mxBean = mxBean;
    }

    public long[] getAllThreadIDs() {
        return mxBean.getAllThreadIds();
    }

    public long[] findDeadlockedThreads() {
        return mxBean.findDeadlockedThreads();
    }

    public long getThreadCpuTime(long id) {
        return mxBean.getThreadCpuTime(id);
    }

    public int getPeakThreadCount() {
        return mxBean.getPeakThreadCount();
    }

    public int getThreadCount() {
        return mxBean.getThreadCount();
    }

    public long getTotalStartedThreadCount() {
        return mxBean.getTotalStartedThreadCount();
    }

    public int getDaemonThreadCount() {
        return mxBean.getDaemonThreadCount();
    }

    public ThreadInfo getThreadInfo(long id) {
        return mxBean.getThreadInfo(id);
    }

    public ThreadInfo[] dumpAllThreads() {
        return mxBean.dumpAllThreads(false, false);
    }

    public String formatThreadInfo(ThreadInfo[] threadInfos) throws UndefinedException {
        return ThreadInfoFormat.format(threadInfos, FormatStrategy.DETAILED_FORMAT);
    }

    @Override
    public ObjectName getObjectName() {
        return mxBean.getObjectName();
    }
}