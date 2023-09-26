package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Default (Template) Project
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/9/26
 **/
public class Main {

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";

        // 解析 JSON 字符串为 JsonObject
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

        // 提取指定的 key 对应的 value
        String name = jsonObject.get("name").getAsString();
        int age = jsonObject.get("age").getAsInt();
        String city = jsonObject.get("city").getAsString();

        // 打印提取出的值
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
    }
}