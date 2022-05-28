package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotNull;

public class EnrollmentReqCreateDTO {
    @NotNull(message = "O campo código do curso é obrigatório")
    private final String courseCode;
    @NotNull(message = "O campo código do aluno é obrigatório")
    private final Integer studentRegister;

    public EnrollmentReqCreateDTO(String courseCode, Integer studentRegister) {
        this.courseCode = courseCode;
        this.studentRegister = studentRegister;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Integer getStudentRegister() {
        return studentRegister;
    }
}
