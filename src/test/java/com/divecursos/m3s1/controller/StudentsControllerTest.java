package com.divecursos.m3s1.controller;

import com.divecursos.m3s1.dto.request.StudentReqCreateDTO;
import com.divecursos.m3s1.dto.response.StudentRespDTO;
import com.divecursos.m3s1.exception.RecordFoundException;
import com.divecursos.m3s1.mapper.StudentMapper;
import com.divecursos.m3s1.model.entity.Student;
import com.divecursos.m3s1.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentsControllerTest {
    @InjectMocks
    private StudentsController studentsController;

    @Mock
    private StudentService studentService;

    @Test
    @DisplayName("Quando o método create é chamado, deve criar com sucesso")
    void create_withValidData() {
        StudentReqCreateDTO studentReqCreateDTO = new StudentReqCreateDTO(123, "fullName");
        Student student = StudentMapper.INSTANCE.toModel(studentReqCreateDTO);

        when(studentService.create(any(Student.class))).thenReturn(student);
        Response response = studentsController.create(studentReqCreateDTO);
        assertNotNull(response.getEntity());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertInstanceOf(StudentRespDTO.class, response.getEntity());
    }

    @Test
    @DisplayName("Quando o método create é chamado com dados de id já criados, deve lançar uma exceção")
    void create_withInvalidData() {
        StudentReqCreateDTO studentReqCreateDTO = new StudentReqCreateDTO(123, "fullName");

        when(studentService.create(any(Student.class))).thenThrow(RecordFoundException.class);

        assertThrows(RecordFoundException.class, () -> studentsController.create(studentReqCreateDTO));
    }
}
