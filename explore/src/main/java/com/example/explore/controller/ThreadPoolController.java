/**
 * explore
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/1
 **/
package com.example.explore.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.example.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class ThreadPoolController {

    private Helper helper;
    private ApplicationContext context;

    @RequestMapping("/info")
    public String getInfo() throws MalformedObjectNameException {
        ObjectName objectName = ObjectName.getInstance("Catalina:type=ThreadPool,*");
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.queryMBeans(objectName, null);
        ThreadPoolExecutor[] executors = helper.getInstances(ThreadPoolExecutor.class);
        ThreadPoolExecutor executor = executors[0];
        Map<String, String> returnMap = new LinkedHashMap<>();
        returnMap.put("核心线程数", String.valueOf(executor.getCorePoolSize()));
        returnMap.put("最大线程数", String.valueOf(executor.getMaximumPoolSize()));
        returnMap.put("活跃线程数", String.valueOf(executor.getActiveCount()));
        returnMap.put("池中当前线程数", String.valueOf(executor.getPoolSize()));
        returnMap.put("历史最大线程数", String.valueOf(executor.getLargestPoolSize()));
        returnMap.put("线程允许空闲时间/s", String.valueOf(executor.getKeepAliveTime(TimeUnit.SECONDS)));
        returnMap.put("核心线程数是否允许被回收", String.valueOf(executor.allowsCoreThreadTimeOut()));
        returnMap.put("提交任务总数", String.valueOf(executor.getSubmittedCount()));
        returnMap.put("历史执行任务的总数(近似值)", String.valueOf(executor.getTaskCount()));
        returnMap.put("历史完成任务的总数(近似值)", String.valueOf(executor.getCompletedTaskCount()));
        returnMap.put("工作队列任务数量", String.valueOf(executor.getQueue().size()));
        returnMap.put("拒绝策略", executor.getRejectedExecutionHandler().getClass().getSimpleName());


        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        mxBean.getThreadCpuTime(mxBean.getAllThreadIds()[0]);
        mxBean.getThreadUserTime(mxBean.getAllThreadIds()[0]);
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        memoryMXBean.getHeapMemoryUsage().getCommitted();
        return returnMap.toString();
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Autowired
    public void setHelper(Helper helper) {
        this.helper = helper;
    }

    private static final String MONITOR_PREFIX = "tomcat_threadPool.";

    private static MBeanServer mbeanServer;

    private static ObjectName objectName = null;

    static {
        try {
            objectName = new ObjectName("Catalina:type=ThreadPool,*");
            mbeanServer = getMBeanServer();
        } catch (MalformedObjectNameException e) {
            // ii
        }
    }

    @GetMapping("/exec")
    public String execute() {
        try {
            // collect thread metrics
            Set<ObjectName> connectorNames = getObjectNames(objectName);
            if (connectorNames.isEmpty()) {
                log.warn("是在SpringBoot中内嵌的Tomcat容器中");
                ThreadPoolExecutor threadPoolExecutor =
                        (ThreadPoolExecutor) ((TomcatWebServer) ((AnnotationConfigServletWebServerApplicationContext) context)
                                .getWebServer()).getTomcat().getConnector().getProtocolHandler().getExecutor();
                log.info("core size: {}", threadPoolExecutor.getCorePoolSize());
            } else {
                log.warn("是在独立的Tomcat容器中");
                for (ObjectName connectorName : connectorNames) {
                    // only check one
                    String subType = connectorName.getKeyProperty("subType");
                    if (subType != null || !isTomcatServer(connectorName.getDomain())) {
                        continue;
                    }

                    String name = ObjectName.unquote(connectorName.getKeyProperty("name"));
                    // 基本不使用的协议
                    if (name.startsWith("ajp")) {
                        continue;
                    }

                    String monitorPort = String.valueOf(mbeanServer.getAttribute(connectorName, "port"));

                    int currentThreadsBusy = (Integer) mbeanServer.getAttribute(connectorName, "currentThreadsBusy");
                    log.info("tomcat.thread.pool.busyCount {}", currentThreadsBusy);

                    int currentThreadCount = (Integer) mbeanServer.getAttribute(connectorName, "currentThreadCount");
                    log.info("tomcat.thread.pool.currentCount {}", currentThreadCount);

                    int minSpareThreads = (Integer) mbeanServer.getAttribute(connectorName, "minSpareThreads");
                    log.info("tomcat.thread.pool.spareCount {}", minSpareThreads);

                    int maxThreads = (Integer) mbeanServer.getAttribute(connectorName, "maxThreads");
                    log.info("tomcat.thread.pool.maxCount {}", maxThreads);

                    boolean pauseThreads = (boolean) mbeanServer.getAttribute(connectorName, "paused");
                    log.info("is paused? {}", pauseThreads);

                    log.info("name: {}", mbeanServer.getAttribute(connectorName, "name"));

                }
                // 在容器里针对APP级别的资源监控
                connectorNames = getObjectNames(new ObjectName("Catalina:type=RequestProcessor," + "worker=\"http-nio"
                        + "-8080\",name=HttpRequest1"));
                log.info("准备获取额外的信息");
                for (ObjectName connectorName : connectorNames) {
                    int requestCount = (Integer) mbeanServer.getAttribute(connectorName, "requestCount");
                    log.info("request count: {}", requestCount);
                }
            }
        } catch (Exception e) {
            log.error("Exception occur when getting connector global stats: ", e);
        }
        return "OK";
    }

    public Set<ObjectName> getObjectNames(ObjectName objectName) {
        if (objectName == null) {
            return new HashSet<>();
        }
        Set<ObjectName> objectNames = mbeanServer.queryNames(objectName, null);
        if (objectNames != null && !objectNames.isEmpty()) {
            return objectNames;
        }
        return new HashSet<>();
    }

    public static MBeanServer getMBeanServer() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        if (MBeanServerFactory.findMBeanServer(null).size() > 0) {
            mBeanServer = MBeanServerFactory.findMBeanServer(null).get(0);
        }
        return mBeanServer;
    }

    private boolean isTomcatServer(String domain) {
        if (domain == null) {
            return false;
        }
        return domain.equalsIgnoreCase("tomcat") || domain.equalsIgnoreCase("catalina");
    }
}
