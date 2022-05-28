package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.RecordNotFoundException;
import com.divecursos.m3s1.model.entity.Enrollment;
import com.divecursos.m3s1.model.repository.EnrollmentRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class EnrollmentService {
    @Inject
    private EnrollmentRepository enrollmentRepository;

    public Enrollment create(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteById(Long id) throws RecordNotFoundException {
        if (!enrollmentRepository.findById(id).isPresent())
            throw new RecordNotFoundException("Enrollment", String.valueOf(id));
        enrollmentRepository.deleteById(id);
    }

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }
}
