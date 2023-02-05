package org.example;



import sun.management.HotspotThreadMBean;
import sun.management.ManagementFactoryHelper;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    static class Person {
        private String name;
        private String password;
        private int age;

        public Person(String name, String password, int age) {
            this.name = name;
            this.password = password;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + ' ' +
                    ", password='" + password + ' ' +
                    ", age=" + age +
                    '}';
        }
    }

    private static final List<Person> list = new ArrayList<>();

    public static void main(String[] args) {
        Helper helper = new Helper();
        System.out.println("执行一次GC");
        helper.forceGc();
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        // HotspotThreadMBean mm = ManagementFactory.
        HotspotThreadMBean mm = ManagementFactoryHelper.getHotspotThreadMBean();

        Person p = new Person("xiaoming", "xiaoming", 1);
        Person p1 = new Person("", "", 2), p2 = new Person("", "", 3);
        System.out.println("获取某个类的所有对象");
        Person[] persons = helper.getInstances(Person.class);
        for (Person pp : persons) System.out.println(pp);
        System.out.println("计算一个类的所有对象大小");
        System.out.println(helper.sumInstanceSize(Person.class));
        System.out.println("计算单个对象大小");
        System.out.println(helper.getInstanceSize(p));
        System.out.println("获取所有加载过的类");
        System.out.println(Arrays.toString(helper.getAllLoadedClasses()));
        System.out.println("Hello world!");
        String[] strs = helper.getInstances(String.class);
        // for (String item : strs) System.out.println(item);
        System.out.println(helper.allocateMemory(10L));
        System.out.flush();

        // Thread t1 = new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         while (true) {
        //             System.out.println(1);
        //             try {
        //                 Thread.sleep(1000);
        //             } catch (InterruptedException e) {
        //                 throw new RuntimeException(e);
        //             }
        //         }
        //     }
        // }, "t1");
        // t1.start();
        // // t1.suspend();
        // helper.suspendThread(t1);
        // for (int i = 0; i < 100_000; ++i) {
        //     list.add(new Person(UUID.randomUUID().toString(), UUID.randomUUID().toString(), i));
        // }
        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         while (true) {
        //             // System.out.println(123);
        //             // try {
        //             //     Thread.sleep(599);
        //             // } catch (InterruptedException e) {
        //             //     throw new RuntimeException(e);
        //             // }
        //         }
        //     }
        // }, "t2").start();

        // Scanner scanner = new Scanner(System.in);
        // while (true) {
        //     System.out.printf("\nPlease input the size for allocate: > ");
        //     long size = scanner.nextLong();
        //     helper.allocateMemory(size);
        // }
    }
}