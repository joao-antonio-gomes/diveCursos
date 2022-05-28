package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class CourseReqCreateDTO implements Serializable {
    @NotNull(message = "O campo 'code' não pode ser nulo.")
    private final String code;
    @NotNull(message = "O campo 'subject' não pode ser nulo.")
    private final String subject;
    @NotNull(message = "O campo 'length' não pode ser nulo.")
    private final Integer length;

    public CourseReqCreateDTO(String code, String subject, Integer length) {
        this.code = code;
        this.subject = subject;
        this.length = length;
    }

    public String getCode() {
        return code;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseReqCreateDTO entity = (CourseReqCreateDTO) o;
        return Objects.equals(this.code, entity.code) &&
                Objects.equals(this.subject, entity.subject) &&
                Objects.equals(this.length, entity.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, subject, length);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "code = " + code + ", " +
                "subject = " + subject + ", " +
                "length = " + length + ")";
    }
}
