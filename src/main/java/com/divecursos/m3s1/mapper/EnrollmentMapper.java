package com.divecursos.m3s1.mapper;

import com.divecursos.m3s1.dto.request.EnrollmentReqCreateDTO;
import com.divecursos.m3s1.dto.response.CourseRespDTO;
import com.divecursos.m3s1.dto.response.EnrollmentRespDTO;
import com.divecursos.m3s1.dto.response.StudentRespDTO;
import com.divecursos.m3s1.model.entity.Course;
import com.divecursos.m3s1.model.entity.Enrollment;
import com.divecursos.m3s1.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnrollmentMapper {
    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

    @Mapping(source = "courseCode", target = "course", qualifiedByName = "courseCodeToCourseEntity")
    @Mapping(source = "studentRegister", target = "student", qualifiedByName = "studentRegisterToStudentEntity")
    public Enrollment toModel(EnrollmentReqCreateDTO enrollmentReqCreateDTO);

    @Named("courseCodeToCourseEntity")
    public static Course courseCodeToCourseEntity(String courseCode) {
        Course course = new Course();
        course.setCode(courseCode);
        return course;
    }

    @Named("studentRegisterToStudentEntity")
    public static Student studentRegisterToStudentEntity(Integer studentRegister) {
        Student student = new Student();
        student.setRegister(studentRegister);
        return student;
    }

    @Mapping(source = "course", target = "course", qualifiedByName = "courseEntityToCourseRespDTO")
    @Mapping(source = "student", target = "student", qualifiedByName = "studentEntityToStudentRespDTO")
    public EnrollmentRespDTO toGenericResponse(Enrollment enrollment);

    @Named("courseEntityToCourseRespDTO")
    public static CourseRespDTO courseEntityToCourseRespDTO(Course course) {
        return CourseMapper.INSTANCE.toGenericResponse(course);
    }

    @Named("studentEntityToStudentRespDTO")
    public static StudentRespDTO studentEntityToStudentityRespDTO(Student student) {
        return StudentMapper.INSTANCE.toGenericResponse(student);
    }
}
