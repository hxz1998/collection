/**
 * mini-pin
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/2
 **/
package org.example;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class TomcatThreadPoolTest {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 20, 1, TimeUnit.DAYS, new LinkedBlockingDeque<>());
        Helper helper = new Helper();
        ThreadPoolExecutor[] executors = helper.getInstances(ThreadPoolExecutor.class);
        System.out.println(executors[0].getCorePoolSize());
        executors[0].shutdown();
        helper.forceGc();
    }
}
