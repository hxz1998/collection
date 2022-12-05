/**
 * Summer
 *
 * @Description: 测试使用
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.test;

public class ApiTest {
    private final Object mutex1 = new Object();
    private final Object mutex2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("你好，我是" + ApiTest.class.getName());
        ApiTest apiTest = new ApiTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (apiTest.mutex1) {
                    System.out.println(Thread.currentThread().getName() + "获取了 mutex1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (apiTest.mutex2) {
                        System.out.println(Thread.currentThread().getName() + "获取了 mutex2");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (apiTest.mutex2) {
                    System.out.println(Thread.currentThread().getName() + "获取了 mutex2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (apiTest.mutex1) {
                        System.out.println(Thread.currentThread().getName() + "获取了 mutex1");
                    }
                }
            }
        }).start();

        while (true) {
            apiTest.hello();
            apiTest.hello("Bob");
            hello(1234567890);
            Thread.sleep(1000);
        }
    }

    public void hello() {
        System.out.println("Hello, World!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void hello(int num) {
        System.out.println(num);
    }


}
