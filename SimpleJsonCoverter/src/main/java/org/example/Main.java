package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * Default (Template) Project
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/9/8
 **/
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text blackText = new Text("Black Text ");
        blackText.setFill(Color.BLACK);
        blackText.setFont(Font.font("System", 12));
        blackText.setId("black");

        Text redText = new Text("Red Text");
        redText.setFill(Color.RED);
        redText.setFont(Font.font("System", 12));
        redText.setId("red");

        TextFlow textFlow = new TextFlow(blackText, redText);
        StackPane stackPane = new StackPane(textFlow);
        stackPane.setPrefSize(300, 200);

        Scene scene = new Scene(stackPane);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        textFlow.setOnMouseClicked(event -> {
            Text selectedText = (Text) event.getTarget();
            if (selectedText != null) {
                String id = selectedText.getId();
                if ("black".equals(id)) {
                    selectedText.setId("black-selected");
                    selectedText.setFill(Color.LIGHTBLUE);
                } else if ("red".equals(id)) {
                    selectedText.setId("red-selected");
                    selectedText.setFill(Color.PINK);
                } else if ("black-selected".equals(id)) {
                    selectedText.setId("black");
                    selectedText.setFill(Color.BLACK);
                } else if ("red-selected".equals(id)) {
                    selectedText.setId("red");
                    selectedText.setFill(Color.RED);
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}