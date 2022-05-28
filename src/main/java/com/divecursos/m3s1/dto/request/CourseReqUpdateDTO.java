package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class CourseReqUpdateDTO implements Serializable {
    private String code;
    @NotNull(message = "O campo subject é obrigatório")
    private final String subject;
    @NotNull(message = "O campo length é obrigatório")
    private final Integer length;

    public CourseReqUpdateDTO(String subject, Integer length) {
        this.subject = subject;
        this.length = length;
    }

    public void setCode(String code) {
        this.code = code;
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
        CourseReqUpdateDTO entity = (CourseReqUpdateDTO) o;
        return Objects.equals(this.subject, entity.subject) &&
                Objects.equals(this.length, entity.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, length);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "subject = " + subject + ", " +
                "length = " + length + ")";
    }
}
