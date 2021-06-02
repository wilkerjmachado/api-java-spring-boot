package com.example.apijavaspringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Client extends AbstractEntity{

    @Column(length = 150, nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
