/**
 * Summer
 *
 * @Description: 对类加载状况进行获取
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.monitor.information;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.monitor.Information;

import javax.management.ObjectName;
import java.lang.management.ClassLoadingMXBean;

@Slf4j
public class ClassLoadingInformation implements Information<ClassLoadingMXBean> {
    @Getter
    private final ClassLoadingMXBean mxBean;

    public ClassLoadingInformation(ClassLoadingMXBean classLoadingMXBean) {
        this.mxBean = classLoadingMXBean;
    }

    public int getLoadedClassCount() {
        return mxBean.getLoadedClassCount();
    }

    public long getTotalLoadedClassCount() {
        return mxBean.getTotalLoadedClassCount();
    }

    public long getUnloadedClassCount() {
        return mxBean.getUnloadedClassCount();
    }

    @Override
    public ObjectName getObjectName() {
        return mxBean.getObjectName();
    }
}
