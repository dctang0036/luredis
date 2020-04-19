package com.luredis.Entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 2569501759987671189L;

    private Integer id;
    private String username;

    public User() {
        //
    }

    public User(Integer id, String username) {
        super();
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
