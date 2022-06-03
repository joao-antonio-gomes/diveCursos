package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.IncorrectInputException;
import com.divecursos.m3s1.exception.RecordNotFoundException;
import com.divecursos.m3s1.model.entity.Student;
import com.divecursos.m3s1.model.repository.EnrollmentRepository;
import com.divecursos.m3s1.model.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Quando procura estudante por nome que não existe, joga erro")
    void findAll_studentNameInexistent() {
        when(studentRepository.findAll(Mockito.anyString())).thenReturn(new ArrayList<>());
        assertThrows(RecordNotFoundException.class, () -> studentService.findAll(Mockito.anyString()));
    }

    @Test
    @DisplayName("Quando retorna lista de estudantes")
    void findAll_returnStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(123, "name"));
        when(studentRepository.findAll(null)).thenReturn(students);
        assertEquals(students, studentService.findAll(null));
        assertEquals(students.size(), studentService.findAll(null).size());
    }

    @Test
    @DisplayName("Quando deleta sem passar registro, joga erro")
    void delete_withoutRegister() {
        assertThrows(IncorrectInputException.class, () -> studentService.deleteByRegister(null));
    }

    @Test
    @DisplayName("Quando deleta estudante que não existe, joga erro")
    void delete_studentNotFound() {
        when(studentRepository.findByRegister(Mockito.anyInt())).thenReturn(Optional.empty());
        assertThrows(RecordNotFoundException.class, () -> studentService.deleteByRegister(Mockito.anyInt()));
    }
}
