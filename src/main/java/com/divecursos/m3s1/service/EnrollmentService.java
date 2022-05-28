package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.RecordNotFoundException;
import com.divecursos.m3s1.model.entity.Course;
import com.divecursos.m3s1.model.entity.Enrollment;
import com.divecursos.m3s1.model.entity.Student;
import com.divecursos.m3s1.model.repository.EnrollmentRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class EnrollmentService {
    @Inject
    private EnrollmentRepository enrollmentRepository;
    @Inject
    private CourseService courseService;
    @Inject
    private StudentService studentService;

    public Enrollment create(Enrollment enrollment) throws RecordNotFoundException {
        Course course = courseService.findByCode(enrollment.getCourse().getCode());
        Student student = studentService.findByRegister(enrollment.getStudent().getRegister());
        enrollment.setCourse(course);
        enrollment.setStudent(student);
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
