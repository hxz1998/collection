/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example.util;


import com.google.gson.Gson;

public class GsonUtil {

    private GsonUtil() {

    }

    private static Gson gson;

    static {
        gson = new Gson();
    }

    public static <R> R covert(String jsonString, Class<R> clazz) {
        return gson.fromJson(jsonString, clazz);
    }
}
