package org.example;

import org.jctools.queues.MpscLinkedQueue;

/**
 * Default (Template) Project
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/8/8
 **/
public class Main {


    public static void main(String[] args) {
        MpscLinkedQueue<String> queue = new MpscLinkedQueue<>();
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!queue.isEmpty()) {
                        if (queue.peek().startsWith("Thread-1")) {
                            System.out.println(queue.poll());
                        } else {
                            queue.poll();
                        }
                    }
                }
            }
        });
//        consumer.start();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; ++i) {
            threads[i] = new Thread(() -> {
                int num = 10000;
                while (num > 0) {
                    queue.offer(Thread.currentThread().getName() + ": " + num--);
                }
            });
        }
        for (int i = 0; i < 1; ++i) {
            threads[i].start();
        }
        while (true) {
        }
    }
}