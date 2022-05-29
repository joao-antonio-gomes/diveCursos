package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CourseReqCreateDTO implements Serializable {
    @NotEmpty(message = "O campo 'code' não pode ser nulo.")
    private String code;
    @NotEmpty(message = "O campo 'subject' não pode ser nulo.")
    private String subject;
    @NotNull(message = "O campo 'length' não pode ser nulo.")
    private Integer length;

    public CourseReqCreateDTO() {
    }

    public CourseReqCreateDTO(String code, String subject, Integer length) {
        this.code = code;
        this.subject = subject;
        this.length = length;
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
