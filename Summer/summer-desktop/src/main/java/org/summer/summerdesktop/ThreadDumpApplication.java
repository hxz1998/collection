/**
 * Summer
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/7/18
 **/
package org.summer.summerdesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ThreadDumpApplication extends Application {

    private FXMLLoader loader = null;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SummerApplication.class.getResource("thread-dump-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.loader = fxmlLoader;
        stage.setScene(scene);
        stage.show();
    }

    public ThreadDumpViewController getController() {
        return this.loader.getController();
    }
}
