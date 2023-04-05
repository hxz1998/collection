/**
 * Raft_Demo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/4/5
 **/
package org.example;

public class StateMachine {
    // 状态机的实现代码
    public void applyLogEntry(LogEntry logEntry) {
        // 将日志条目应用到状态机上
    }
}

class LogEntry {
    private int term; // 日志条目所在的任期
    private int index; // 日志条目在日志中的索引位置
    // 其他相应的信息

    // 构造函数
    public LogEntry(int term, int index) {
        this.term = term;
        this.index = index;
    }

    // Getters 和 Setters
    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

