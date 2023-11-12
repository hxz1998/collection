/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private GsonUtil() {

    }

    private static final Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Class.class, new ClassTypeAdapter());
        gson = gsonBuilder.create();

    }

    public static <R> R toObject(String jsonString, Class<R> clazz) {
        return gson.fromJson(jsonString, clazz);
    }

    public static <T> String toJson(T data) {
        return gson.toJson(data);
    }
}
