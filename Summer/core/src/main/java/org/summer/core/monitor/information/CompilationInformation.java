/**
 * Summer
 *
 * @Description: 对 JIT 信息进行获取
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor.information;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.monitor.Information;

import javax.management.ObjectName;
import java.lang.management.CompilationMXBean;

@Slf4j
public class CompilationInformation implements Information<CompilationMXBean> {
    @Getter
    private final CompilationMXBean mxBean;

    public CompilationInformation(CompilationMXBean compilationMXBean) {
        this.mxBean = compilationMXBean;
    }

    public String getCompilerName() {
        return mxBean.getName();
    }

    public long getTotalCompilationTime() {
        return mxBean.getTotalCompilationTime();
    }


    @Override
    public ObjectName getObjectName() {
        return mxBean.getObjectName();
    }
}
