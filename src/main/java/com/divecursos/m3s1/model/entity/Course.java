package com.divecursos.m3s1.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    private String code;
    private String subject;
    private Integer length; // in days

    public Course() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
