package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.IncorrectInputException;
import com.divecursos.m3s1.exception.RecordFoundException;
import com.divecursos.m3s1.exception.RecordNotFoundException;
import com.divecursos.m3s1.model.entity.Course;
import com.divecursos.m3s1.model.entity.Enrollment;
import com.divecursos.m3s1.model.repository.CourseRepository;
import com.divecursos.m3s1.model.repository.EnrollmentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;
    @Mock
    private EnrollmentRepository enrollmentRepository;

    Course getCourseEntity() {
        return new Course("123", "subject", 1);
    }

    @Test
    @DisplayName("Quando tenta criar curso com código já existente, joga erro")
    void create_courseCodeAlreadyRegistered() {
        when(courseRepository.findByCode("123")).thenReturn(Optional.of(getCourseEntity()));
        assertThrows(RecordFoundException.class, () -> courseService.create(getCourseEntity()));
    }

    @Test
    @DisplayName("Quando tenta deletar um curso e não passa código, joga erro")
    void delete_courseCodeNull() {
        assertThrows(IncorrectInputException.class, () -> courseService.deleteByCode(null));
    }

    @Test
    @DisplayName("Quando tenta deletar um curso e não encontra o curso, joga erro")
    void delete_courseNotFound() {
        when(courseRepository.findByCode(anyString())).thenReturn(Optional.empty());
        assertThrows(RecordNotFoundException.class, () -> courseService.deleteByCode("123"));
    }

    @Test
    @DisplayName("Quando tenta deletar um curso que contém matrículas, joga erro")
    void delete_courseWithEnrollments() {
        when(courseRepository.findByCode(anyString())).thenReturn(Optional.of(getCourseEntity()));
        when(enrollmentRepository.findByCourseCode(anyString())).thenReturn(List.of(new Enrollment()));
        assertThrows(RecordFoundException.class, () -> courseService.deleteByCode("123"));
    }

    @Test
    @DisplayName("Quando tenta encontrar curso por código nulo, joga erro")
    void findByCode_courseCodeNull() {
        assertThrows(IncorrectInputException.class, () -> courseService.findByCode(null));
    }

    @Test
    @DisplayName("Quando tenta encontrar curso por código inexistente, joga erro")
    void findByCode_courseNotFound() {
        when(courseRepository.findByCode(anyString())).thenReturn(Optional.empty());
        assertThrows(RecordNotFoundException.class, () -> courseService.findByCode("123"));
    }

    @Test
    @DisplayName("Quando tenta encontrar curso por código existente, retorna curso")
    void findByCode_courseFound() {
        when(courseRepository.findByCode(anyString())).thenReturn(Optional.of(getCourseEntity()));
        assertEquals(getCourseEntity().getCode(), courseService.findByCode("123").getCode());
        assertInstanceOf(Course.class, courseService.findByCode("123"));
    }
}
