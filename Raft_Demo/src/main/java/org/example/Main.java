package org.example;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 初始化节点
        Node node1 = new Node("node1", new StateMachine(), 0, 0, 0, 0);
        Node node2 = new Node("node2", new StateMachine(), 0, 0, 0, 0);
        Node node3 = new Node("node3", new StateMachine(), 0, 0, 0, 0);

        // 初始化主节点
        Leader leader = new Leader(0, 0, 0,
                new HashMap<String, Integer>(), new HashMap<String, Integer>());

        // 启动节点线程
        Thread thread1 = new Thread(new NodeThread(node1, leader));
        Thread thread2 = new Thread(new NodeThread(node2, leader));
        Thread thread3 = new Thread(new NodeThread(node3, leader));
        thread1.start();
        thread2.start();
        thread3.start();

        // 等待节点线程结束
        thread1.join();
        thread2.join();
        thread3.join();
    }
}

class NodeThread implements Runnable {
    private Node node;
    private Leader leader;

    public NodeThread(Node node, Leader leader) {
        this.node = node;
        this.leader = leader;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

}