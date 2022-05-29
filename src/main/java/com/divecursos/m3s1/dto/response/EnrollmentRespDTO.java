package com.divecursos.m3s1.dto.response;

import java.io.Serializable;
import java.util.Objects;

public class EnrollmentRespDTO implements Serializable {
    private Long id;
    private StudentRespDTO student;
    private CourseRespDTO course;

    public EnrollmentRespDTO() {
    }

    public EnrollmentRespDTO(Long id, StudentRespDTO student, CourseRespDTO course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentRespDTO getStudent() {
        return student;
    }

    public void setStudent(StudentRespDTO student) {
        this.student = student;
    }

    public CourseRespDTO getCourse() {
        return course;
    }

    public void setCourse(CourseRespDTO course) {
        this.course = course;
    }
}
