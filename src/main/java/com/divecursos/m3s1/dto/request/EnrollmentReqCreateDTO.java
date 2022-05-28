package com.divecursos.m3s1.dto.request;

public class EnrollmentReqCreateDTO {
    private final String courseCode;
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
