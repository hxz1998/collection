/**
 * Summer
 *
 * @Description: 选择虚拟机的界面
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.summerdesktop;

import com.sun.tools.attach.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.exception.AttachCurrentVMException;
import org.summer.core.exception.VirtualMachineUnsupported;
import org.summer.core.monitor.view.ProviderImpl;
import org.summer.core.util.VirtualMachineHelper;
import org.summer.core.util.VmRegisterCenter;

import java.io.IOException;
import java.util.List;

@Slf4j
public class SelectVmApplication extends Application {

    @Override
    public void start(Stage stage) {
        List<VirtualMachineDescriptor> descriptors = VirtualMachineHelper.list();
        log.debug("一共有 " + descriptors.size() + " 台虚拟机");
        BorderPane borderPane = new BorderPane();
        borderPane.setMinWidth(600);
        borderPane.setMinHeight(300);
        VBox vBox = new VBox();
        vBox.setPrefWidth(Region.USE_COMPUTED_SIZE);
        vBox.setMinWidth(borderPane.getMinWidth());
        vBox.setPrefHeight(Region.USE_COMPUTED_SIZE);
        vBox.setAlignment(Pos.CENTER);
        VmRegisterCenter.clear();
        for (VirtualMachineDescriptor descriptor : descriptors) {
            // 屏蔽开发工具虚拟机，这些不可修改！
            if (descriptor.displayName().contains("jetbrain") ||
                    descriptor.displayName().contains("maven") ||
                    descriptor.displayName().contains("netbean") ||
                    descriptor.displayName().isEmpty()) {
                continue;
            }
            VmRegisterCenter.add(descriptor.id(), descriptor);
            Button attachToVmButton = new Button(descriptor.id() + " : " + descriptor.displayName().split(" ")[0]);
            attachToVmButton.setWrapText(true);
            attachToVmButton.setMinWidth(300);
            attachToVmButton.setMaxWidth(300);
            attachToVmButton.setAlignment(Pos.CENTER);
            attachToVmButton.setOnAction(e -> {
                try {
                    SummerApplication.dataProvider = new ProviderImpl();
                    VirtualMachine machine = VirtualMachineHelper.attach(descriptor.id());
                    SummerApplication.dataProvider.inject(machine);
                    try {
                        machine.loadAgent("D:\\source\\Java\\Summer\\core\\target\\core-1.0-SNAPSHOT-jar-with-dependencies.jar");
                    } catch (AgentLoadException | AgentInitializationException ex) {
                        log.error("注入核心时失败！");
                        throw new RuntimeException(ex);
                    }
                    log.debug("注入核心成功！");
                    SummerApplication.initBeans();
                    SummerApplication.setVM(descriptor);
                    SummerApplication.enable();
                    stage.close();
                    log.debug("注册到了" + descriptor.id());
                } catch (AttachCurrentVMException ex) {
                    log.debug("尝试连接到当前的虚拟机，不行！");
                } catch (VirtualMachineUnsupported ex) {
                    log.debug("不支持的虚拟机类型");
                    throw new RuntimeException(ex);
                } catch (IOException | AttachNotSupportedException ex) {
                    throw new RuntimeException(ex);
                }
            });
            vBox.getChildren().add(attachToVmButton);
        }
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
}
