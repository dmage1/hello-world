package com.example.myproject.domain;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int id;
    private final String content;

    public Customer() {
        this.id = 0;
        this.content = "";
    }

    public Customer(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
