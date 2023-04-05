/**
 * Raft_Demo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/4/5
 **/
package org.example;

class Node {
    private String id; // 节点ID
    private StateMachine stateMachine; // 状态机
    private int currentTerm; // 当前任期
    private int lastKnownTerm; // 最后一次知道的任期
    private int lastLogIndex; // 最后一条日志的索引
    private int lastLogTerm; // 最后一条日志的任期

    // 构造函数
    public Node(String id, StateMachine stateMachine, int currentTerm,
                int lastKnownTerm, int lastLogIndex, int lastLogTerm) {
        this.id = id;
        this.stateMachine = stateMachine;
        this.currentTerm = currentTerm;
        this.lastKnownTerm = lastKnownTerm;
        this.lastLogIndex = lastLogIndex;
        this.lastLogTerm = lastLogTerm;
    }

    // Getters 和 Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public int getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(int currentTerm) {
        this.currentTerm = currentTerm;
    }

    public int getLastKnownTerm() {
        return lastKnownTerm;
    }

    public void setLastKnownTerm(int lastKnownTerm) {
        this.lastKnownTerm = lastKnownTerm;
    }

    public int getLastLogIndex() {
        return lastLogIndex;
    }

    public void setLastLogIndex(int lastLogIndex) {
        this.lastLogIndex = lastLogIndex;
    }

    public int getLastLogTerm() {
        return lastLogTerm;
    }

    public void setLastLogTerm(int lastLogTerm) {
        this.lastLogTerm = lastLogTerm;
    }
}
