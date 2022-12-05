/**
 * Summer
 *
 * @Description: MXBean仓库接口，可以直接用来注册和获取
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.util;

import org.summer.core.common.MXBeanType;
import org.summer.core.exception.NoConnectionException;

import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.lang.management.*;
import java.util.List;

public interface MXBeanFactory {
    PlatformManagedObject getMXBean(MXBeanType type) throws NoConnectionException, IOException;

    List<MemoryPoolMXBean> getMemoryPoolMXBean() throws NoConnectionException, IOException;

    List<GarbageCollectorMXBean> getGarbageCollectorMXBeans() throws IOException, NoConnectionException;

    MemoryMXBean getMemoryMXBean() throws NoConnectionException, IOException;

    CompilationMXBean getCompilationMXBean() throws NoConnectionException, IOException;

    OperatingSystemMXBean getOperationSystemMXBean() throws NoConnectionException, IOException;

    RuntimeMXBean getRuntimeMXBean() throws NoConnectionException, IOException;

    ThreadMXBean getThreadMXBean() throws NoConnectionException, IOException;

    ClassLoadingMXBean getClassLoadingMXBean() throws NoConnectionException, IOException;

    void setMBeanServerConnection(MBeanServerConnection connection);
}
