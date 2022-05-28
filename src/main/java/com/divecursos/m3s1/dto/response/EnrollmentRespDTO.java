package com.divecursos.m3s1.dto.response;

import java.io.Serializable;
import java.util.Objects;

public class EnrollmentRespDTO implements Serializable {
    private final Long id;
    private final StudentRespDTO student;
    private final CourseRespDTO course;

    public EnrollmentRespDTO(Long id, StudentRespDTO student, CourseRespDTO course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public StudentRespDTO getStudent() {
        return student;
    }

    public CourseRespDTO getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentRespDTO entity = (EnrollmentRespDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.student, entity.student) &&
                Objects.equals(this.course, entity.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, course);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "student = " + student + ", " +
                "course = " + course + ")";
    }
}
