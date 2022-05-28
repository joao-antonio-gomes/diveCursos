package com.divecursos.m3s1.dto.request;

import java.io.Serializable;
import java.util.Objects;

public class StudentReqUpdateDTO implements Serializable {
    private Integer register;
    private final String fullName;

    public StudentReqUpdateDTO(String fullName) {
        this.fullName = fullName;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentReqUpdateDTO entity = (StudentReqUpdateDTO) o;
        return Objects.equals(this.fullName, entity.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "fullName = " + fullName + ")";
    }
}
