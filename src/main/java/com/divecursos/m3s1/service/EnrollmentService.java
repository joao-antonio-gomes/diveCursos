package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.RecordFoundException;
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

    public Enrollment create(Enrollment enrollment) {
        Course course = courseService.findByCode(enrollment.getCourse().getCode());
        Student student = studentService.findByRegister(enrollment.getStudent().getRegister());
        if (enrollmentRepository.findEnrollmentByCourseAndStudent(course, student).isPresent())
            throw new RecordFoundException("Enrollment", "Course and Student already exists");
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        return enrollmentRepository.save(enrollment);
    }

    public void deleteById(Long id) {
        if (!enrollmentRepository.findById(id).isPresent())
            throw new RecordNotFoundException("Enrollment", String.valueOf(id));
        enrollmentRepository.deleteById(id);
    }

    public List<Enrollment> findAll() {
        List<Enrollment> enrollmentList = enrollmentRepository.findAll();
        if (enrollmentList.size() == 0)
            throw new RecordNotFoundException("Enrollment", "No records found");
        return enrollmentList;
    }
}
