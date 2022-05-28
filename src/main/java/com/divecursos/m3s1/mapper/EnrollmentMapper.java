package com.divecursos.m3s1.mapper;

import com.divecursos.m3s1.dto.request.EnrollmentReqCreateDTO;
import com.divecursos.m3s1.dto.response.EnrollmentRespDTO;
import com.divecursos.m3s1.model.entity.Course;
import com.divecursos.m3s1.model.entity.Enrollment;
import com.divecursos.m3s1.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
abstract class EnrollmentMapper {
    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

    public Enrollment toModel(EnrollmentReqCreateDTO enrollmentReqCreateDTO) {
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(new Course());
        enrollment.getCourse().setCode(enrollmentReqCreateDTO.getCourseCode());
        enrollment.setStudent(new Student());
        enrollment.getStudent().setRegister(enrollmentReqCreateDTO.getStudentRegister());
        return enrollment;
    }

    public EnrollmentRespDTO toGenericResponde(Enrollment enrollment) {
        return new EnrollmentRespDTO(
                enrollment.getId(),
                StudentMapper.INSTANCE.toGenericResponse(enrollment.getStudent()),
                CourseMapper.INSTANCE.toGenericResponse(enrollment.getCourse())
        );
    }
}
