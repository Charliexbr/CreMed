package com.peiz.caremed.entity;

public class Statistics {
    private String user_id;
    private int topays;
    private int todos;

    // 无参构造函数
    public Statistics() {
    }

    // 带参构造函数
    public Statistics(String user_id, int topays, int todos) {
        this.user_id = user_id;
        this.topays = topays;
        this.todos = todos;
    }

    // Getter 和 Setter 方法
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getTopays() {
        return topays;
    }

    public void setTopays(int topays) {
        this.topays = topays;
    }

    public int getTodos() {
        return todos;
    }

    public void setTodos(int todos) {
        this.todos = todos;
    }
}

