/**
 * Raft_Demo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/4/5
 **/
package org.example;

import java.util.Map;

class Leader {
    private int term; // 当前任期
    private int commitIndex; // 已知最大的已经被提交的日志条目的索引值
    private int lastApplied; // 已经被应用到状态机的最高日志条目的索引值
    private Map<String, Integer> nextIndex; // 每个节点的下一条日志索引值
    private Map<String, Integer> matchIndex; // 已经复制给每个节点的日志的最高索引值

    // 构造函数
    public Leader(int term, int commitIndex, int lastApplied,
                  Map<String, Integer> nextIndex, Map<String, Integer> matchIndex) {
        this.term = term;
        this.commitIndex = commitIndex;
        this.lastApplied = lastApplied;
        this.nextIndex = nextIndex;
        this.matchIndex = matchIndex;
    }

    // Getters 和 Setters
    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCommitIndex() {
        return commitIndex;
    }

    public void setCommitIndex(int commitIndex) {
        this.commitIndex = commitIndex;
    }

    public int getLastApplied() {
        return lastApplied;
    }

    public void setLastApplied(int lastApplied) {
        this.lastApplied = lastApplied;
    }

    public Map<String, Integer> getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(Map<String, Integer> nextIndex) {
        this.nextIndex = nextIndex;
    }

    public Map<String, Integer> getMatchIndex() {
        return matchIndex;
    }

    public void setMatchIndex(Map<String, Integer> matchIndex) {
        this.matchIndex = matchIndex;
    }
}

