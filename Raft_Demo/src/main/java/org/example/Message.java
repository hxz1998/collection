/**
 * Raft_Demo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/4/5
 **/
package org.example;
class Message {
    private String from; // 发送者ID
    private String to; // 接收者ID
    private Type type; // 消息类型
    private int term; // 当前任期
    // 其他相应的信息

    // 消息类型
    public enum Type {
        REQUEST_VOTE, // 请求投票
        VOTE, // 投票
        APPEND_ENTRIES, // 日志追加
        HEARTBEAT // 心跳检测
    }

    // 构造函数
    public Message(String from, String to, Type type, int term) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.term = term;
    }

    // Getters 和 Setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}

