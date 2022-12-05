/**
 * Summer
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/7/17
 **/
package org.summer.core.util;

import org.summer.core.exception.UndefinedException;

import java.lang.management.LockInfo;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;

public class ThreadInfoFormat {

    private static final String separator = "   ";

    public static String format(ThreadInfo[] threadInfos, FormatStrategy strategy) throws UndefinedException {
        switch (strategy) {
            case SIMPLE_FORMAT:
                throw new UndefinedException();
            case DETAILED_FORMAT:
                return detailFormat(threadInfos);
        }
        return null;
    }

    private static String detailFormat(ThreadInfo[] threadInfos) {
        StringBuilder builder = new StringBuilder();
        for (ThreadInfo threadInfo : threadInfos) {
            builder.append("ID:").append(" ").append(threadInfo.getThreadId()).append("   ")
                    .append("Name:").append(" ").append(threadInfo.getThreadName()).append("\n")
                    .append("Thread State:").append(" ").append(threadInfo.getThreadState()).append("\n")
                    .append("Daemon:").append(" ").append(threadInfo.isDaemon()).append("\n")
                    .append("Suspended:").append(" ").append(threadInfo.isSuspended()).append("\n")
                    .append("In Native:").append(" ").append(threadInfo.isInNative()).append("\n")
                    .append("Waited Time:").append(" ").append(threadInfo.getWaitedTime()).append("\n")
                    .append("Waited Count:").append(" ").append(threadInfo.getWaitedCount()).append("\n")
                    .append("Blocked Count:").append(" ").append(threadInfo.getBlockedCount()).append("\n")
                    .append("Blocked Time:").append(" ").append(threadInfo.getBlockedTime()).append("\n")
                    .append("Lock Name:").append(" ").append(threadInfo.getLockName()).append("\n")
                    .append("Lock Info").append(" ").append(threadInfo.getLockInfo() == null ? "null" : threadInfo.getLockInfo().getClassName()).append("\n")
                    .append("Lock Owner ID:").append(" ").append(threadInfo.getLockOwnerId()).append("   ")
                    .append("Lock Owner Name:").append(" ").append(threadInfo.getLockOwnerName()).append("\n");
            builder.append("[Locked Synchronizers]").append("\n");
            if (threadInfo.getLockedSynchronizers().length == 0) {
                builder.append("   Empty List").append("\n");
            } else {
                for (LockInfo lockInfo : threadInfo.getLockedSynchronizers()) {
                    builder.append("   ").append("[Synchronizers Info]:").append(" ").append(lockInfo.getClassName()).append("\n    ")
                            .append(lockInfo.getIdentityHashCode()).append("\n");
                }
            }

            builder.append("[Locked Monitors]").append("\n");
            if (threadInfo.getLockedMonitors().length == 0) {
                builder.append("   Empty List").append("\n");
            } else {
                for (MonitorInfo monitorInfo : threadInfo.getLockedMonitors()) {
                    builder.append("   ").append("Monitor Info: ").append(monitorInfo.getClassName()).append("#").append(monitorInfo.getIdentityHashCode()).append("\n    ")
                            .append("Locked Stack Depth: ").append(monitorInfo.getLockedStackDepth()).append("\n");
                    // TODO 处理一下被锁的栈帧信息
                    StackTraceElement traceElement = monitorInfo.getLockedStackFrame();
                }
            }
            builder.append("[Stack Trace]").append("\n");
            for (StackTraceElement traceElement : threadInfo.getStackTrace()) {
                builder.append("   - ").append(traceElement.getMethodName()).append(" ").append(traceElement.getFileName()).append(": ").append(traceElement.getLineNumber())
                        .append("\n");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
