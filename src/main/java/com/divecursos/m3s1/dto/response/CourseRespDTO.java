package com.divecursos.m3s1.dto.response;

import java.io.Serializable;
import java.util.Objects;

public class CourseRespDTO implements Serializable {
    private String code;
    private String subject;
    private Integer length;

    public CourseRespDTO() {
    }

    public CourseRespDTO(String code, String subject, Integer length) {
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
