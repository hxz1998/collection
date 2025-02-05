/**
 * flink-kafka
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/12/9
 **/
package org.example;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.datastream.AsyncDataStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.async.AsyncFunction;
import org.apache.flink.streaming.api.functions.async.ResultFuture;

public class AsyncFunctionPlayground {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> input = env.fromData("hello world", "world");
        AsyncDataStream.orderedWait(input, new AsyncFunction<String, String>() {
            @Override
            public void asyncInvoke(String input, ResultFuture<String> resultFuture) throws Exception {
                System.out.println(input);
                if (input.equals("hello")) {
                    Thread.sleep(2000);
                }
                resultFuture.complete(Arrays.asList(input.split(" ")));
            }

            @Override
            public void timeout(String input, ResultFuture<String> resultFuture) throws Exception {
                System.out.println(input + "超时了");
            }
        }, 1000, TimeUnit.MILLISECONDS, 100).print();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    load();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    load();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        load();

        env.execute();
    }

    private static void load() throws InterruptedException {
        Counter counter = new Counter();
        while (counter.count < Long.MAX_VALUE) {
            counter.count++;
        }
        Thread.sleep(2000);
    }

    private static class Counter {
        long count = Long.MIN_VALUE;
    }
}
