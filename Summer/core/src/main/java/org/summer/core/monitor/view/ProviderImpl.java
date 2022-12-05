/**
 * Summer
 *
 * @Description: 数据提供者实现
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.monitor.view;

import com.sun.tools.attach.VirtualMachine;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.common.MXBeanType;
import org.summer.core.exception.NoConnectionException;
import org.summer.core.exception.UndefinedException;
import org.summer.core.exception.VirtualMachineUnsupported;
import org.summer.core.monitor.Information;
import org.summer.core.monitor.Provider;
import org.summer.core.monitor.information.*;
import org.summer.core.util.JMXConnectionHelper;
import org.summer.core.util.MXBeanFactory;
import org.summer.core.util.MXBeanFactoryImpl;

import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ProviderImpl implements Provider {

    private final MXBeanFactory mxBeanFactory;

    private final Map<MXBeanType, Information<?>> mapper;

    public ProviderImpl() {
        mxBeanFactory = new MXBeanFactoryImpl();
        mapper = new HashMap<>();
    }

    @Override
    public void inject(VirtualMachine vmd) throws VirtualMachineUnsupported {
        try {
            MBeanServerConnection connection = JMXConnectionHelper.getConnection(vmd);
            mxBeanFactory.setMBeanServerConnection(connection);
            ClassLoadingInformation classLoadingInformation = new ClassLoadingInformation(mxBeanFactory.getClassLoadingMXBean());
            mapper.put(MXBeanType.ClassLoadingMXBean, classLoadingInformation);

            CompilationInformation compilationInformation = new CompilationInformation(mxBeanFactory.getCompilationMXBean());
            mapper.put(MXBeanType.CompilationMXBean, compilationInformation);

            GarbageCollectorsInformation garbageCollectorsInformation = new GarbageCollectorsInformation(mxBeanFactory.getGarbageCollectorMXBeans());
            mapper.put(MXBeanType.GarbageCollectorMXBean, garbageCollectorsInformation);

            MemoryInformation memoryInformation = new MemoryInformation(mxBeanFactory.getMemoryMXBean());
            mapper.put(MXBeanType.MemoryMXBean, memoryInformation);

            MemoryPoolsInformation memoryPoolsInformation = new MemoryPoolsInformation(mxBeanFactory.getMemoryPoolMXBean());
            mapper.put(MXBeanType.MemoryPoolMXBean, memoryPoolsInformation);

            RuntimeInformation runtimeInformation = new RuntimeInformation(mxBeanFactory.getRuntimeMXBean());
            mapper.put(MXBeanType.RuntimeMXBean, runtimeInformation);
            SystemInformation systemInformation = new SystemInformation(mxBeanFactory.getOperationSystemMXBean());
            mapper.put(MXBeanType.OperationSystemMXBean, systemInformation);
            ThreadInformation threadInformation = new ThreadInformation(mxBeanFactory.getThreadMXBean());
            mapper.put(MXBeanType.ThreadMXBean, threadInformation);
        } catch (IOException e) {
            log.error("启动本地管理代理对象时 vmd.startLocalManagementAgent() 时出错了");
            e.printStackTrace();
        } catch (NoConnectionException e) {
            log.error("MXBeanFactory 尚未连接到 JVM");
            e.printStackTrace();
        }
    }

    @Override
    public List<MXBeanType> list() {
        return new ArrayList<>(mapper.keySet());
    }

    @Override
    public <T> T get(MXBeanType type, Class<T> clazz) throws UndefinedException {
        if (mapper.containsKey(type)) return clazz.cast(mapper.get(type));
        return null;
    }
}
