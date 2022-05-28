package com.divecursos.m3s1.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private Integer register;
    private String fullName;

    public Student() {
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
