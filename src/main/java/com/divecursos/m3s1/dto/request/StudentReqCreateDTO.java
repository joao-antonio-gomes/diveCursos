package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class StudentReqCreateDTO implements Serializable {
    @NotNull(message = "O campo register é obrigatório")
    private final Integer register;
    @NotNull(message = "O campo fullName é obrigatório")
    private final String fullName;

    public StudentReqCreateDTO(Integer register, String fullName) {
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
        StudentReqCreateDTO entity = (StudentReqCreateDTO) o;
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
