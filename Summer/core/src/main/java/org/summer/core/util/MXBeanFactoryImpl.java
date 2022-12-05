/**
 * Summer
 *
 * @Description: 具体的实现类
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.util;

import org.summer.core.common.MXBeanType;
import org.summer.core.exception.NoConnectionException;

import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.lang.management.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MXBeanFactoryImpl implements MXBeanFactory {


    private MBeanServerConnection connection = null;

    private List<MemoryPoolMXBean> memoryPoolMXBeans = null;
    private List<GarbageCollectorMXBean> garbageCollectorMXBeans = null;
    private final Map<MXBeanType, PlatformManagedObject> mapper;

    public MXBeanFactoryImpl() {
        mapper = new HashMap<>();
    }

    public MXBeanFactoryImpl(MBeanServerConnection conn) {
        connection = conn;
        mapper = new HashMap<>();
    }

    @Override
    public PlatformManagedObject getMXBean(MXBeanType type) throws NoConnectionException, IOException {
        if (null == connection)
            throw new NoConnectionException();
        if (mapper.containsKey(type)) {
            return mapper.get(type);
        }
        PlatformManagedObject ret = null;
        switch (type) {
            case MemoryMXBean:
                ret = ManagementFactory.newPlatformMXBeanProxy(connection, ManagementFactory.MEMORY_MXBEAN_NAME, MemoryMXBean.class);
                break;
            case CompilationMXBean:
                ret = ManagementFactory.newPlatformMXBeanProxy(connection, ManagementFactory.COMPILATION_MXBEAN_NAME, CompilationMXBean.class);
                break;
            case OperationSystemMXBean:
                ret = ManagementFactory.newPlatformMXBeanProxy(connection, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, com.sun.management.OperatingSystemMXBean.class);
                break;
            case RuntimeMXBean:
                ret = ManagementFactory.newPlatformMXBeanProxy(connection, ManagementFactory.RUNTIME_MXBEAN_NAME, RuntimeMXBean.class);
                break;
            case ThreadMXBean:
                ret = ManagementFactory.newPlatformMXBeanProxy(connection, ManagementFactory.THREAD_MXBEAN_NAME, ThreadMXBean.class);
                break;
            case ClassLoadingMXBean:
                ret = ManagementFactory.newPlatformMXBeanProxy(connection, ManagementFactory.CLASS_LOADING_MXBEAN_NAME, ClassLoadingMXBean.class);
                break;
        }
        mapper.put(type, ret);
        return ret;
    }

    @Override
    public List<MemoryPoolMXBean> getMemoryPoolMXBean() throws NoConnectionException, IOException {
        if (null == connection)
            throw new NoConnectionException();
        if (memoryPoolMXBeans != null) return memoryPoolMXBeans;
        memoryPoolMXBeans = ManagementFactory.getPlatformMXBeans(connection, MemoryPoolMXBean.class);
        return memoryPoolMXBeans;
    }

    @Override
    public List<GarbageCollectorMXBean> getGarbageCollectorMXBeans() throws IOException, NoConnectionException {
        if (null == connection) throw new NoConnectionException();
        if (null != garbageCollectorMXBeans) return garbageCollectorMXBeans;
        garbageCollectorMXBeans = ManagementFactory.getPlatformMXBeans(connection, GarbageCollectorMXBean.class);
        return garbageCollectorMXBeans;
    }

    @Override
    public MemoryMXBean getMemoryMXBean() throws NoConnectionException, IOException {
        return (MemoryMXBean) getMXBean(MXBeanType.MemoryMXBean);
    }

    @Override
    public CompilationMXBean getCompilationMXBean() throws NoConnectionException, IOException {
        return (CompilationMXBean) getMXBean(MXBeanType.CompilationMXBean);
    }

    @Override
    public OperatingSystemMXBean getOperationSystemMXBean() throws NoConnectionException, IOException {
        return (OperatingSystemMXBean) getMXBean(MXBeanType.OperationSystemMXBean);
    }

    @Override
    public RuntimeMXBean getRuntimeMXBean() throws NoConnectionException, IOException {
        return (RuntimeMXBean) getMXBean(MXBeanType.RuntimeMXBean);
    }

    @Override
    public ThreadMXBean getThreadMXBean() throws NoConnectionException, IOException {
        return (ThreadMXBean) getMXBean(MXBeanType.ThreadMXBean);
    }

    @Override
    public ClassLoadingMXBean getClassLoadingMXBean() throws NoConnectionException, IOException {
        return (ClassLoadingMXBean) getMXBean(MXBeanType.ClassLoadingMXBean);
    }

    @Override
    public void setMBeanServerConnection(MBeanServerConnection connection) {
        this.connection = connection;
    }

}
