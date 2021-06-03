package com.example.apijavaspringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Client extends AbstractEntity{

    @Column(length = 150, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public Client(String name, Integer age) {
        this();
        this.name = name;
        this.age = age;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
