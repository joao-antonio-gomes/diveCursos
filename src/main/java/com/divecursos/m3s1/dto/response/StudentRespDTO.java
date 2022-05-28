package com.divecursos.m3s1.dto.response;

import java.io.Serializable;
import java.util.Objects;

public class StudentRespDTO implements Serializable {
    private final Integer register;
    private final String fullName;

    public StudentRespDTO(Integer register, String fullName) {
        this.register = register;
        this.fullName = fullName;
    }

    public Integer getRegister() {
        return register;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRespDTO entity = (StudentRespDTO) o;
        return Objects.equals(this.register, entity.register) &&
                Objects.equals(this.fullName, entity.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(register, fullName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "register = " + register + ", " +
                "fullName = " + fullName + ")";
    }
}
