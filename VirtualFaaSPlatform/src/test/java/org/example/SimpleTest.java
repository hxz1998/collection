/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example;

import java.lang.reflect.InvocationTargetException;

public class SimpleTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Integer integer = Integer.getInteger("1");
        System.out.println(Integer.class.getMethod("valueOf", String.class).invoke(null, "20"));
    }
}
