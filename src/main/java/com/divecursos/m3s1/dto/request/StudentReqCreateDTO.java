package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class StudentReqCreateDTO implements Serializable {
    @NotNull(message = "O campo register é obrigatório")
    private Integer register;
    @NotNull(message = "O campo fullName é obrigatório")
    private String fullName;

    public StudentReqCreateDTO(Integer register, String fullName) {
        this.register = register;
        this.fullName = fullName;
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
