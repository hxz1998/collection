/**
 * Neo4jUserGuide
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/19
 **/
package org.example.util;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class GsonUtil {

    private GsonUtil() {
    }

    private static final Gson gson = new Gson();

    public static <T> String toJson(T obj) {
        return gson.toJson(obj);
    }

    public static <T> T toObject(Class<T> clazz, String jsonString) {
        return gson.fromJson(jsonString, clazz);
    }
}
