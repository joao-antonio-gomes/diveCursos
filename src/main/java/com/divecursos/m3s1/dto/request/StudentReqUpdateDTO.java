package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class StudentReqUpdateDTO implements Serializable {
    private Integer register;
    @NotNull(message = "O campo fullName é obrigatório")
    private String fullName;

    public StudentReqUpdateDTO(String fullName) {
        this.fullName = fullName;
    }

    public StudentReqUpdateDTO() {
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
