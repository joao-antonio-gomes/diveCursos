package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.RecordFoundException;
import com.divecursos.m3s1.exception.RecordNotFoundException;
import com.divecursos.m3s1.model.entity.Student;
import com.divecursos.m3s1.model.repository.EnrollmentRepository;
import com.divecursos.m3s1.model.repository.StudentRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class StudentService {
    @Inject
    private StudentRepository studentRepository;
    @Inject
    private EnrollmentRepository enrollmentRepository;

    public Student create(Student student) throws RecordFoundException {
        if (studentRepository.findByRegister(student.getRegister()).isPresent()) {
            throw new RecordFoundException("Student register", String.valueOf(student.getRegister()));
        }
        return studentRepository.save(student);
    }

    public Student update(Student student) throws RecordNotFoundException {
        if (!studentRepository.findByRegister(student.getRegister()).isPresent())
            throw new RecordNotFoundException("Student", String.valueOf(student.getRegister()));
        return studentRepository.merge(student);
    }

    public void deleteByRegister(Integer register) throws RecordNotFoundException {
        if (!studentRepository.findByRegister(register).isPresent())
            throw new RecordNotFoundException("Student register", String.valueOf(register));
        enrollmentRepository.findByStudentRegister(register)
                .forEach(enrollment -> enrollmentRepository.remove(enrollment));
        studentRepository.deleteByRegister(register);
    }

    public Student findByRegister(Integer register) throws RecordNotFoundException {
        Optional<Student> student = studentRepository.findByRegister(register);
        if (!student.isPresent())
            throw new RecordNotFoundException("Student", String.valueOf(register));
        return student.get();
    }

    public List<Student> findAll(String studentName) throws RecordNotFoundException {
        List<Student> studentsFound = studentRepository.findAll(studentName);
        if (studentsFound.isEmpty())
            throw new RecordNotFoundException("Student", studentName);
        return studentsFound;
    }
}
