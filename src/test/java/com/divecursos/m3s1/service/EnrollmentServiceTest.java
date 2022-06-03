package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.IncorrectInputException;
import com.divecursos.m3s1.exception.RecordNotFoundException;
import com.divecursos.m3s1.model.entity.Enrollment;
import com.divecursos.m3s1.model.repository.EnrollmentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnrollmentServiceTest {
    @InjectMocks
    private EnrollmentService enrollmentService;

    @Mock
    private EnrollmentRepository enrollmentRepository;

    @Test
    @DisplayName("Quando não encontra inscrição, joga erro")
    void deleteById_notFoundEnrollment() {
        when(enrollmentRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RecordNotFoundException.class, () -> enrollmentService.deleteById(1L));
    }

    @Test
    @DisplayName("Quando é passado ID por parâmetro, joga erro")
    void deleteById_notReceiveId() {
        assertThrows(IncorrectInputException.class, () -> enrollmentService.deleteById(null));
    }

    @Test
    @DisplayName("Quando não é encontrado nenhuma inscrição, joga erro")
    void findAll_notFoundEnrollment() {
        when(enrollmentRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(RecordNotFoundException.class, () -> enrollmentService.findAll());
    }

    @Test
    @DisplayName("Retorna inscrições quando encontrado")
    void findAll_foundEnrollment() {
        List<Enrollment> enrollmentList = new ArrayList<>();
        enrollmentList.add(new Enrollment());
        when(enrollmentRepository.findAll()).thenReturn(enrollmentList);
        assertNotNull(enrollmentService.findAll());
        assertEquals(enrollmentList.size(), enrollmentService.findAll().size());
    }


}
