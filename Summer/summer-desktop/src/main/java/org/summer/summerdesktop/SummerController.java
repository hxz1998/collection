/**
 * Summer
 *
 * @Description: 主界面控制器
 * @Author: cherry
 * @Create on: 2022/6/24
 **/
package org.summer.summerdesktop;

import com.itextpdf.text.DocumentException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.common.Property;
import org.summer.core.network.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Slf4j
public class SummerController {
    @FXML
    BorderPane footPane;

    @FXML
    TabPane centerPane;

    private int chartLength = 200;
    @FXML
    Button connectButton;
    @FXML
    LineChart heapSpace;
    private XYChart.Series heapMaxSeries = new XYChart.Series();
    private XYChart.Series heapCommittedSeries = new XYChart.Series();
    private XYChart.Series heapUsedSeries = new XYChart.Series();

    @FXML
    LineChart nonHeapSpace;
    private XYChart.Series nonHeapMaxSeries = new XYChart.Series();
    private XYChart.Series nonHeapCommittedSeries = new XYChart.Series();
    private XYChart.Series nonHeapUsedSeries = new XYChart.Series();

    @FXML
    LineChart classCount;
    @FXML
    LineChart unloadClassCount;
    private XYChart.Series classLoadingSeries = new XYChart.Series();
    private XYChart.Series classUnloadingSeries = new XYChart.Series();


    @FXML
    LineChart threadCount;
    private XYChart.Series peakThreadCount = new XYChart.Series();
    private XYChart.Series currentThreadCount = new XYChart.Series();
    private XYChart.Series totalThreadCount = new XYChart.Series();


    @FXML
    LineChart gcYoungChartCount;
    @FXML
    LineChart gcYoungChartTime;
    @FXML
    LineChart gcOldChartCount;
    @FXML
    LineChart gcOldChartTime;
    private XYChart.Series youngCountSeries = new XYChart.Series();
    private XYChart.Series youngTimeSeries = new XYChart.Series();
    private XYChart.Series oldCountSeries = new XYChart.Series();
    private XYChart.Series oldTimeSeries = new XYChart.Series();

    @FXML
    LineChart compilationChart;
    private XYChart.Series compilationTime = new XYChart.Series();


    @FXML
    ProgressBar metaSpace;

    @FXML
    ProgressBar g1EdenSpace;

    @FXML
    ProgressBar g1OldSpace;

    @FXML
    ProgressBar g1Survivor;

    @FXML
    Button performGC;

    @FXML
    ListView<String> classList;

    @FXML
    Button scan;

    @FXML
    TextField packageName;

    @FXML
    Label className;

    @FXML
    TextArea classContent;

    @FXML
    TableView runtimePropertiesView;
    @FXML
    TableColumn propertyName;
    @FXML
    TableColumn propertyValue;

    @FXML
    TableView operationSystemPropertiesView;
    @FXML
    TableColumn operationSystemPropertyName;
    @FXML
    TableColumn operationSystemPropertyValue;

    @FXML
    ChoiceBox timeIntervalSelect;

    @FXML
    Accordion methodsList;

    @FXML
    protected void onPerformGC() {
        SummerApplication.gc();
    }


    @FXML
    Label vmDescription;

    @FXML
    Button threadDumpButton;

    @FXML
    protected void onConnectButtonClick() throws Exception {
        SelectVmApplication selectVmApplication = new SelectVmApplication();
        selectVmApplication.start(new Stage());
    }

    @FXML
    protected void onScanButtonClick() {
        if (packageName.getText().isEmpty()) return;
        classList.getItems().clear();
        Response<List<String>> classes = SummerApplication.getClient().send(new Request(RequestType.LIST_CLASSES, packageName.getText()), Response.class);
        for (String clazz : classes.getValue()) {
            classList.getItems().add(clazz);
        }
        classList.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            className.setText(newValue.toString());
            log.debug(newValue);
            classContent.setText((String) SummerApplication.getClient().send(new Request(RequestType.GET_CLASS_CONTENT, newValue), Response.class).getValue());
            classContent.setFont(Font.font("Courier New"));
            log.debug("字体设置是: " + classContent.getFont().getName());
            Response<LinkedList<String>> methods = SummerApplication.getClient().send(new Request(RequestType.LIST_METHOD, newValue), Response.class);
            LinkedList<String> methodsNames = methods.getValue();
            for (String item : methods.getValue()) {
                log.debug("探测到有这样的方法: " + item);
            }
            TitledPane[] titledPanes = new TitledPane[methodsNames.size()];
            for (int idx = 0; idx < methodsNames.size(); ++idx) {
                String targetMethod = methodsNames.get(idx);
                titledPanes[idx] = new TitledPane();
                AnchorPane subPane = new AnchorPane();
                TextArea code = new TextArea();
                code.setFont(Font.font("Courier New"));
                Button performChange = new Button("生效");
                BorderPane borderPane = new BorderPane(code, null, null, performChange, null);
                AnchorPane.setBottomAnchor(borderPane, 0.0);
                AnchorPane.setLeftAnchor(borderPane, 0.0);
                AnchorPane.setRightAnchor(borderPane, 0.0);
                AnchorPane.setTopAnchor(borderPane, 0.0);
                subPane.getChildren().add(borderPane);
                BorderPane.setAlignment(performChange, Pos.CENTER);
                BorderPane.setMargin(performChange, new Insets(3, 0, 0, 0));
                BorderPane.setAlignment(code, Pos.CENTER);
                titledPanes[idx].setContent(subPane);

                titledPanes[idx].setText(targetMethod);

                performChange.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String label = newValue + "#" + targetMethod;
                        ModifyEntity entity = new ModifyEntity(label, code.getText());
                        log.debug("尝试修改: " + label);
                        Response response = SummerApplication.getClient().send(new Request<ModifyEntity>(RequestType.MODIFY, entity), Response.class);
                        if (response.getType() == ResponseType.OK) {
                            log.debug("修改： " + label + " 成功");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Summer - Desktop");
                            alert.setHeaderText("修改 " + entity.getLabel() + " 成功");
                            alert.setContentText(response.getMsg());
                            alert.showAndWait();
                        } else {
                            log.debug("修改： " + label + " 失败");
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Summer - Desktop");
                            alert.setHeaderText("修改 " + entity.getLabel() + " 失败");
                            alert.setContentText("出现了一些问题\n" + response.getMsg());
                            alert.showAndWait();
                        }
                    }
                });
            }
            methodsList.getPanes().clear();
            methodsList.getPanes().addAll(titledPanes);
        });
    }

    public void initialization() {
        heapCommittedSeries.setName("堆提交内存");
        heapUsedSeries.setName("堆使用内存");
        heapSpace.getData().addAll(heapCommittedSeries, heapUsedSeries);

        nonHeapCommittedSeries.setName("非堆提交内存");
        nonHeapUsedSeries.setName("非堆使用内存");
        nonHeapSpace.getData().addAll(nonHeapCommittedSeries, nonHeapUsedSeries);

        classLoadingSeries.setName("已加载");
        classUnloadingSeries.setName("未加载");
        classCount.getData().addAll(classLoadingSeries);
        unloadClassCount.getData().add(classUnloadingSeries);

        currentThreadCount.setName("存活线程数");
        totalThreadCount.setName("线程总数");
        peakThreadCount.setName("峰值线程数");
        threadCount.getData().addAll(currentThreadCount, totalThreadCount, peakThreadCount);

        youngCountSeries.setName("回收次数");
        youngTimeSeries.setName("回收耗时");
        oldCountSeries.setName("回收次数");
        oldTimeSeries.setName("回收耗时");
        gcYoungChartCount.getData().add(youngCountSeries);
        gcYoungChartTime.getData().add(youngTimeSeries);
        gcOldChartCount.getData().add(oldCountSeries);
        gcOldChartTime.getData().add(oldTimeSeries);

        compilationTime.setName("编译总耗时");
        compilationChart.getData().add(compilationTime);

        timeIntervalSelect.getItems().addAll(2000, 1000, 500, 100);
        timeIntervalSelect.getSelectionModel().select(1);
        timeIntervalSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (oldValue != newValue) SummerApplication.setTimeInterval((Integer) newValue);
                log.debug("发现换了测量速度");
            }
        });
    }

    public void initProperties() {
        Map<String, String> runtimeProperties = SummerApplication.getRuntimeProperties();
        ObservableList<Property> properties = FXCollections.observableArrayList();
        propertyName.setCellValueFactory(new PropertyValueFactory<>("key"));
        propertyValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        for (Map.Entry<String, String> entry : runtimeProperties.entrySet()) {
            properties.add(new Property(entry.getKey(), entry.getValue()));
        }
        runtimePropertiesView.setItems(properties);

        Map<String, String> operationSystemProperties = SummerApplication.getOperationSystemProperties();
        ObservableList<Property> operationProperties = FXCollections.observableArrayList();
        operationSystemPropertyName.setCellValueFactory(new PropertyValueFactory<>("key"));
        operationSystemPropertyValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        for (Map.Entry<String, String> entry : operationSystemProperties.entrySet()) {
            operationProperties.add(new Property(entry.getKey(), entry.getValue()));
        }
        operationSystemPropertiesView.setItems(operationProperties);
    }

    public void updateHeapSpace(XYChart.Data max, XYChart.Data committed, XYChart.Data used) {
        if (heapMaxSeries.getData().size() >= chartLength) {
            heapMaxSeries.getData().remove(0);
            heapCommittedSeries.getData().remove(0);
            heapUsedSeries.getData().remove(0);
        }
        heapMaxSeries.getData().add(max);
        heapCommittedSeries.getData().add(committed);
        heapUsedSeries.getData().add(used);
    }

    public void updateNonHeapSpace(XYChart.Data max, XYChart.Data committed, XYChart.Data used) {
        if (nonHeapMaxSeries.getData().size() >= chartLength) {
            nonHeapMaxSeries.getData().remove(0);
            nonHeapCommittedSeries.getData().remove(0);
            nonHeapUsedSeries.getData().remove(0);
        }
        nonHeapMaxSeries.getData().add(max);
        nonHeapCommittedSeries.getData().add(committed);
        nonHeapUsedSeries.getData().add(used);
    }

    public void updateClassloading(XYChart.Data loading, XYChart.Data unloading) {
        if (classLoadingSeries.getData().size() >= chartLength) {
            classLoadingSeries.getData().remove(0);
            classUnloadingSeries.getData().remove(0);
        }
        classLoadingSeries.getData().add(loading);
        classUnloadingSeries.getData().add(unloading);
    }

    public void updateThreadCount(XYChart.Data current, XYChart.Data peak, XYChart.Data total) {
        if (currentThreadCount.getData().size() >= chartLength) {
            currentThreadCount.getData().remove(0);
            peakThreadCount.getData().remove(0);
            totalThreadCount.getData().remove(0);
        }
        currentThreadCount.getData().add(current);
        peakThreadCount.getData().add(peak);
        totalThreadCount.getData().add(total);
    }

    public void updateGC(XYChart.Data youngCount, XYChart.Data youngTime, XYChart.Data oldCount, XYChart.Data oldTime) {
        if (youngCountSeries.getData().size() >= chartLength) {
            youngCountSeries.getData().remove(0);
            youngTimeSeries.getData().remove(0);
            oldCountSeries.getData().remove(0);
            oldTimeSeries.getData().remove(0);
        }
        youngCountSeries.getData().add(youngCount);
        youngTimeSeries.getData().add(youngTime);
        oldCountSeries.getData().add(oldCount);
        oldTimeSeries.getData().add(oldTime);
    }

    public void updateCompilation(XYChart.Data time) {
        if (compilationTime.getData().size() > chartLength) {
            compilationTime.getData().remove(0);
        }
        compilationTime.getData().add(time);
    }

    public void setVmDescription(String desc) {
        vmDescription.setText(desc);
        vmDescription.setWrapText(true);
    }

    public void updateDetailInformation(double ms, double eden, double old, double survivor) {
        metaSpace.setProgress(ms);
        g1EdenSpace.setProgress(eden);
        g1OldSpace.setProgress(old);
        g1Survivor.setProgress(survivor);
    }

    public void onThreadDumpClick() throws Exception {
        try {
            String result = SummerApplication.getThreadInformation().formatThreadInfo(SummerApplication.getThreadInformation().dumpAllThreads());

            ThreadDumpApplication threadDumpApplication = new ThreadDumpApplication();
            threadDumpApplication.start(new Stage());
            threadDumpApplication.getController().setThreadDumpInfo(result);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void enable() {
        centerPane.setDisable(false);
        footPane.setDisable(false);
        threadDumpButton.setDisable(false);
    }
}