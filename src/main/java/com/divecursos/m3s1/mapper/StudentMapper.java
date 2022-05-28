package com.divecursos.m3s1.mapper;

import com.divecursos.m3s1.dto.request.StudentReqCreateDTO;
import com.divecursos.m3s1.dto.request.StudentReqUpdateDTO;
import com.divecursos.m3s1.dto.response.StudentRespDTO;
import com.divecursos.m3s1.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toModel(StudentReqCreateDTO studentReqCreateDTO);
    Student toModel(StudentReqUpdateDTO studentReqUpdateDTO);
    StudentRespDTO toGenericResponse(Student model);
}
