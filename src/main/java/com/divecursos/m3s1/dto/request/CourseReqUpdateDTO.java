package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class CourseReqUpdateDTO implements Serializable {
    private String code;
    @NotNull(message = "O campo subject é obrigatório")
    private String subject;
    @NotNull(message = "O campo length é obrigatório")
    private Integer length;

    public CourseReqUpdateDTO() {
    }

    public CourseReqUpdateDTO(String subject, Integer length) {
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
