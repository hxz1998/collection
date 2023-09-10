package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MyWindow extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        // 创建SplitPane和左右两个TextArea
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        TextArea leftTextArea = new TextArea();
        leftTextArea.setFont(Font.font("Courier New", 15));
        TextArea rightTextArea = new TextArea();
        rightTextArea.setFont(Font.font("Courier New", 15));
        splitPane.getItems().addAll(leftTextArea, rightTextArea);
        root.setCenter(splitPane);

        // 在底部添加两个按钮
        Button formatButton = new Button("格式化并排序");
        Button copyButton = new Button("复制到剪切板");
        BorderPane bottomPane = new BorderPane();
        bottomPane.setLeft(formatButton);
        bottomPane.setRight(copyButton);
        root.setBottom(bottomPane);

        // 格式化并排序按钮监听器
        formatButton.setOnAction(event -> {
            String leftText = leftTextArea.getText();
            String rightText = rightTextArea.getText();
            if (leftText != null && !leftText.isEmpty()) {// 格式化和排序左侧JSON
                String formattedAndSortedLeft = formatAndSortJson(leftText);// 更新TextArea的内容
                leftTextArea.setText(formattedAndSortedLeft);
            }
            if (rightText != null && !rightText.isEmpty()) {
                // 格式化和排序右侧JSON
                String formattedAndSortedRight = formatAndSortJson(rightText);
                rightTextArea.setText(formattedAndSortedRight);
            }
        });

        // 复制到剪切板按钮监听器
        copyButton.setOnAction(event -> {
            String leftText = leftTextArea.getText();
            // 将左侧TextArea的内容复制到剪切板
            copyToClipboard(leftText.replaceAll("\\s", ""));
        });

        stage.setTitle("My Window");
        stage.setScene(scene);
        stage.show();
    }

    private String formatAndSortJson(String jsonText) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        try {
            JsonObject jsonObject = parser.parse(jsonText).getAsJsonObject();

            // 排序JSON
            JsonObject sortedJson = sortJsonObject(jsonObject);

            return gson.toJson(sortedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private JsonObject sortJsonObject(JsonObject jsonObject) {
        JsonObject sortedJson = new JsonObject();
        jsonObject.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                String key = entry.getKey();
                Object valueObj = entry.getValue();
                if (valueObj instanceof JsonObject) {
                    sortedJson.add(key, sortJsonObject((JsonObject) valueObj));
                } else if (valueObj instanceof JsonArray) {
                    sortedJson.add(key, sortJsonArray((JsonArray) valueObj));
                } else {
                    sortedJson.add(key, entry.getValue());
                }
            });
        return sortedJson;
    }

    private JsonArray sortJsonArray(JsonArray array) {
        JsonArray sortedArray = new JsonArray();
        array.forEach(element -> {
            if (element instanceof JsonObject) {
                sortedArray.add(sortJsonObject((JsonObject) element));
            } else if (element instanceof JsonArray) {
                sortedArray.add(sortJsonArray((JsonArray) element));
            } else {
                sortedArray.add(element);
            }
        });
        return sortedArray;
    }

    private void copyToClipboard(String text) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }
}
