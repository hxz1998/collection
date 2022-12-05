/**
 * Summer
 *
 * @Description: 主要功能类
 * 提供了数据定时更新，数据接口的类
 * @Author: cherry
 * @Create on: 2022/6/24
 **/
package org.summer.summerdesktop;

import com.sun.tools.attach.VirtualMachineDescriptor;
import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.common.CacheFile;
import org.summer.core.common.MXBeanType;
import org.summer.core.exception.UndefinedException;
import org.summer.core.monitor.information.*;
import org.summer.core.monitor.view.ProviderImpl;
import org.summer.core.network.AgentProxyClient;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.MemoryUsage;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SummerApplication extends Application {

    public static ProviderImpl dataProvider = null;
    public static int timeInterval = 1000;
    private static SummerController summerController = null;

    public volatile static boolean isReady = false;

    private static final MainDataTask mainDataTask = new MainDataTask();
    private static final DetailDataTask detailDataTask = new DetailDataTask();

    private static long time = 0;

    private static MemoryInformation memoryInformation = null;
    private static ClassLoadingInformation classLoadingInformation = null;
    private static ThreadInformation threadInformation = null;
    private static GarbageCollectorsInformation garbageCollectorsInformation = null;
    private static CompilationInformation compilationInformation = null;
    private static MemoryPoolsInformation memoryPoolsInformation = null;
    private static RuntimeInformation runtimeInformation = null;
    private static SystemInformation systemInformation = null;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static Map<String, String> runtimeProperties = null;

    @Getter
    private static AgentProxyClient client;
    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(SummerApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        // 获取 Controller，并初始化对象
        summerController = fxmlLoader.getController();
        summerController.initialization();

        stage.setTitle("Summer");
        stage.setScene(scene);
        stage.setOnCloseRequest(windowEvent -> onClose());
        stage.show();

        mainDataTask.setDelay(Duration.millis(0));
        mainDataTask.setPeriod(Duration.millis(timeInterval));
        mainDataTask.valueProperty().addListener((observableValue, oldValues, newValues) -> {
            String x = LocalTime.now().format(formatter);
            if (null != newValues) {
                XYChart.Data max = new XYChart.Data<>(x, newValues.get(0));
                XYChart.Data committed = new XYChart.Data<>(x, newValues.get(1));
                XYChart.Data used = new XYChart.Data<>(x, newValues.get(2));
                summerController.updateHeapSpace(max, committed, used);

                max = new XYChart.Data<>(x, newValues.get(3));
                committed = new XYChart.Data<>(x, newValues.get(4));
                used = new XYChart.Data<>(x, newValues.get(5));
                summerController.updateNonHeapSpace(max, committed, used);

                XYChart.Data classLoadingCount = new XYChart.Data(x, newValues.get(6));
                XYChart.Data classUnloadingCount = new XYChart.Data(x, newValues.get(7));
                summerController.updateClassloading(classLoadingCount, classUnloadingCount);

                XYChart.Data currentThreadCount = new XYChart.Data(x, newValues.get(8));
                XYChart.Data peakThreadCount = new XYChart.Data(x, newValues.get(9));
                XYChart.Data totalThreadCount = new XYChart.Data(x, newValues.get(10));
                summerController.updateThreadCount(currentThreadCount, peakThreadCount, totalThreadCount);

                XYChart.Data g1YoungGCCount = new XYChart.Data(x, newValues.get(11));
                XYChart.Data g1YoungGCTime = new XYChart.Data(x, newValues.get(12));
                XYChart.Data g1OldGCCount = new XYChart.Data(x, newValues.get(13));
                XYChart.Data g1OldGCTime = new XYChart.Data(x, newValues.get(14));
                summerController.updateGC(g1YoungGCCount, g1YoungGCTime, g1OldGCCount, g1OldGCTime);

                XYChart.Data compileTime = new XYChart.Data(x, newValues.get(15));
                summerController.updateCompilation(compileTime);
                time++;
            }
        });

        detailDataTask.setPeriod(Duration.millis(timeInterval));
        detailDataTask.valueProperty().addListener((observableValue, oldValues, newValues) -> {
            if (null != newValues) {
                summerController.updateDetailInformation(newValues.get(0), newValues.get(1), newValues.get(2), newValues.get(3));
            }
        });
    }

    public static void initBeans() {
        if (!mainDataTask.isRunning()) mainDataTask.start();
        if (!detailDataTask.isRunning()) detailDataTask.start();
        try {
            memoryInformation = dataProvider.get(MXBeanType.MemoryMXBean, MemoryInformation.class);
            classLoadingInformation = dataProvider.get(MXBeanType.ClassLoadingMXBean, ClassLoadingInformation.class);
            threadInformation = dataProvider.get(MXBeanType.ThreadMXBean, ThreadInformation.class);
            garbageCollectorsInformation = dataProvider.get(MXBeanType.GarbageCollectorMXBean, GarbageCollectorsInformation.class);
            compilationInformation = dataProvider.get(MXBeanType.CompilationMXBean, CompilationInformation.class);
            memoryPoolsInformation = dataProvider.get(MXBeanType.MemoryPoolMXBean, MemoryPoolsInformation.class);

            runtimeInformation = dataProvider.get(MXBeanType.RuntimeMXBean, RuntimeInformation.class);
            systemInformation = dataProvider.get(MXBeanType.OperationSystemMXBean, SystemInformation.class);

            summerController.initProperties();

            log.debug("初始化各项管理器完成");
            client = new AgentProxyClient("127.0.0.1", 8888);
            log.debug("初始化代理客户端完成");
        } catch (UndefinedException e) {
            throw new RuntimeException(e);
        }
    }

    static class DetailDataTask extends ScheduledService<ArrayList<Double>> {

        @Override
        protected Task<ArrayList<Double>> createTask() {
            return new Task<>() {
                @Override
                protected ArrayList<Double> call() {
                    ArrayList<Double> ret = new ArrayList<>();
                    log.debug("开始获取详细数据");
                    MemoryUsage metaUsage = memoryPoolsInformation.getMetaSpaceMXBean().getUsage();
                    MemoryUsage g1EdenUsage = memoryPoolsInformation.getG1EdenMXBean().getUsage();
                    MemoryUsage g1OldUsage = memoryPoolsInformation.getG1OldMXBean().getUsage();
                    MemoryUsage g1Survivor = memoryPoolsInformation.getG1SurvivorMXBean().getUsage();
                    ret.add(1.0 * metaUsage.getUsed() / metaUsage.getCommitted());
                    ret.add(1.0 * g1EdenUsage.getUsed() / g1EdenUsage.getCommitted());
                    ret.add(1.0 * g1OldUsage.getUsed() / g1OldUsage.getCommitted());
                    ret.add(1.0 * g1Survivor.getUsed() / g1Survivor.getCommitted());
                    return ret;
                }
            };
        }
    }

    static class MainDataTask extends ScheduledService<ArrayList<Number>> {
        @Override
        protected Task<ArrayList<Number>> createTask() {
            return new Task<>() {
                @Override
                protected ArrayList<Number> call() throws Exception {
                    ArrayList<Number> ret = new ArrayList<>();
                    log.debug("开始获取主要数据");
                    ret.add(memoryInformation.getHeapMax());
                    ret.add(memoryInformation.getHeapCommitted());
                    ret.add(memoryInformation.getHeapUsed());
                    ret.add(memoryInformation.getNonHeapMax());
                    ret.add(memoryInformation.getNonHeapCommitted());
                    ret.add(memoryInformation.getNonHeapUsed());

                    ret.add(classLoadingInformation.getLoadedClassCount());
                    ret.add(classLoadingInformation.getUnloadedClassCount());

                    ret.add(threadInformation.getThreadCount());
                    ret.add(threadInformation.getPeakThreadCount());
                    ret.add(threadInformation.getTotalStartedThreadCount());

                    for (GarbageCollectorMXBean bean : garbageCollectorsInformation.getGarbageCollectors()) {
                        ret.add(bean.getCollectionCount());
                        ret.add(bean.getCollectionTime());
                    }
                    ret.add(compilationInformation.getTotalCompilationTime());
                    return ret;
                }
            };
        }
    }

    private void onClose() {
        mainDataTask.cancel();
        mainDataTask.reset();
        detailDataTask.cancel();
        detailDataTask.reset();
        CacheFile.cacheFileDelete();
    }

    public static void gc() {
        log.debug("进行了一次 GC 操作");
        memoryInformation.gc();
    }

    public static void setVM(VirtualMachineDescriptor descriptor) {
        summerController.setVmDescription(descriptor.id() + "-" + descriptor.displayName().split(" ")[0]);
    }

    public static void enable() {
        summerController.enable();
    }

    public static Map<String, String> getRuntimeProperties() {
        if (null == runtimeProperties) runtimeProperties = runtimeInformation.getSystemProperties();
        return runtimeProperties;
    }

    public static Map<String, String> getOperationSystemProperties() {
        Map<String, String> ret = new HashMap<>();
        ret.put("计算机名称", systemInformation.getName());
        ret.put("处理器体系结构", systemInformation.getArch());
        ret.put("版本号", systemInformation.getVersion());
        ret.put("处理器核心数", String.valueOf(systemInformation.getAvailableProcessors()));
        ret.put("系统负载", String.valueOf(systemInformation.getSystemLoadAverage() == -1 ?
                "不支持的属性" : systemInformation.getSystemLoadAverage()));
        return ret;
    }

    public static void setTimeInterval(int newValue) {
        log.debug("新的测量速度" + newValue);
        timeInterval = newValue;
        mainDataTask.setPeriod(Duration.millis(timeInterval));
        detailDataTask.setPeriod(Duration.millis(timeInterval));
    }

    public static MemoryInformation getMemoryInformation() {
        return memoryInformation;
    }

    public static ClassLoadingInformation getClassLoadingInformation() {
        return classLoadingInformation;
    }

    public static ThreadInformation getThreadInformation() {
        return threadInformation;
    }

    public static GarbageCollectorsInformation getGarbageCollectorsInformation() {
        return garbageCollectorsInformation;
    }

    public static CompilationInformation getCompilationInformation() {
        return compilationInformation;
    }

    public static MemoryPoolsInformation getMemoryPoolsInformation() {
        return memoryPoolsInformation;
    }

    public static RuntimeInformation getRuntimeInformation() {
        return runtimeInformation;
    }

    public static SystemInformation getSystemInformation() {
        return systemInformation;
    }

    public static Stage getSTage() {
        return stage;
    }
}