package com.divecursos.m3s1.controller;

import com.divecursos.m3s1.dto.request.CourseReqCreateDTO;
import com.divecursos.m3s1.dto.response.CourseRespDTO;
import com.divecursos.m3s1.exception.IncorrectInputException;
import com.divecursos.m3s1.exception.RecordFoundException;
import com.divecursos.m3s1.exception.RecordNotFoundException;
import com.divecursos.m3s1.mapper.CourseMapper;
import com.divecursos.m3s1.model.entity.Course;
import com.divecursos.m3s1.service.CourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoursesControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CoursesController coursesController;

    Course getCourseEntity() {
        return new Course("123", "subject", 1);
    }

    CourseReqCreateDTO getCourseRequestDTO() {
        return new CourseReqCreateDTO("123", "subject", 1);
    }

    @Test
    @DisplayName("Quando requisição com id válido e existente, retornar objeto com status 200")
    void getByCode_success() {
        String code = anyString();

        when(courseService.findByCode(code)).thenReturn(getCourseEntity());
        Response result = coursesController.getByCode(code);

        assertNotNull(result);
        assertNotNull(result.getEntity());
        assertEquals(Response.Status.OK.getStatusCode(), result.getStatus());
        assertInstanceOf(CourseRespDTO.class, result.getEntity());
    }

    @Test
    @DisplayName("Quando requisição com id válido e inexistente, jogar falha")
    void getByCode_notFound() {
        when(courseService.findByCode(anyString())).thenThrow(RecordNotFoundException.class);
        assertThrows(RecordNotFoundException.class, () -> coursesController.getByCode("etc"));
    }

    @Test
    @DisplayName("Quando requisição com id null, jogar falha")
    void getByCode_notHaveCode() {
        when(courseService.findByCode(null)).thenThrow(IncorrectInputException.class);
        assertThrows(IncorrectInputException.class, () -> coursesController.getByCode(null));
    }

    @Test
    @DisplayName("Quando há cursos, retorna array com 1 curso")
    void getAll_returnOneCourse() {
        List<Course> courses = List.of(getCourseEntity());

        when(courseService.getAll(null, null)).thenReturn(courses);
        Response result = coursesController.getAll(null, null);

        assertNotNull(result.getEntity());
        assertEquals(Response.Status.OK.getStatusCode(), result.getStatus());
        assertInstanceOf(List.class, result.getEntity());
        List<CourseRespDTO> courseList = (List<CourseRespDTO>) result.getEntity();
        assertEquals(courseList.size(), 1);
    }

    @Test
    @DisplayName("Quando parâmetro \"sort\" é informado incorretamente, joga erro")
    void getAll_sortIsIncorrect() {
        String sort = "abcde";
        when(courseService.getAll(sort, null)).thenThrow(IncorrectInputException.class);
        assertThrows(IncorrectInputException.class, () -> coursesController.getAll(sort, null));
    }

    @Test
    @DisplayName("Quando recebe requisição com informações corretas, cria o curso")
    void create_correctCourseRequest() {
        CourseReqCreateDTO courseRequestDTO = getCourseRequestDTO();
        Course course = CourseMapper.INSTANCE.toModel(courseRequestDTO);

        when(courseService.create(Mockito.any(Course.class))).thenReturn(course);
        Response response = coursesController.create(courseRequestDTO);

        assertNotNull(response.getEntity());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertInstanceOf(CourseRespDTO.class, response.getEntity());
    }

    @Test
    @DisplayName("Quando recebe requisição com curso com código já cadastrado, joga erro de conflito")
    void create_courseRequestWithExistingCode() {
        CourseReqCreateDTO courseRequestDTO = getCourseRequestDTO();
        Course course = CourseMapper.INSTANCE.toModel(courseRequestDTO);

        lenient().when(courseService.create(Mockito.any(Course.class))).thenThrow(RecordFoundException.class);

        assertThrows(RecordFoundException.class, () -> coursesController.create(courseRequestDTO));
    }
}
