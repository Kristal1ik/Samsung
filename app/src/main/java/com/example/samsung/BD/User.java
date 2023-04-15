package com.example.samsung.BD;

import androidx.annotation.NonNull;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;

    public User(long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}

