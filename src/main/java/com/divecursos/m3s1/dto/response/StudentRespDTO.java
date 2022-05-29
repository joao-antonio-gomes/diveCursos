package com.divecursos.m3s1.dto.response;

import java.io.Serializable;
import java.util.Objects;

public class StudentRespDTO implements Serializable {
    private Integer register;
    private String fullName;

    public StudentRespDTO() {
    }

    public StudentRespDTO(Integer register, String fullName) {
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
