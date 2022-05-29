package com.divecursos.m3s1.dto.request;

import javax.validation.constraints.NotNull;

public class EnrollmentReqCreateDTO {
    @NotNull(message = "O campo código do curso é obrigatório")
    private String courseCode;
    @NotNull(message = "O campo código do aluno é obrigatório")
    private Integer studentRegister;

    public EnrollmentReqCreateDTO() {
    }

    public EnrollmentReqCreateDTO(String courseCode, Integer studentRegister) {
        this.courseCode = courseCode;
        this.studentRegister = studentRegister;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getStudentRegister() {
        return studentRegister;
    }

    public void setStudentRegister(Integer studentRegister) {
        this.studentRegister = studentRegister;
    }
}
