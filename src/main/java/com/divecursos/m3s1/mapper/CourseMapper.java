package com.divecursos.m3s1.mapper;

import com.divecursos.m3s1.dto.request.CourseReqCreateDTO;
import com.divecursos.m3s1.dto.request.CourseReqUpdateDTO;
import com.divecursos.m3s1.dto.response.CourseRespDTO;
import com.divecursos.m3s1.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    Course toModel(CourseReqCreateDTO courseReqCreateDTO);
    Course toModel(CourseReqUpdateDTO courseReqUpdateDTO);
    CourseRespDTO toGenericResponse(Course model);
}
