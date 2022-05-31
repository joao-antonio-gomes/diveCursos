package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.IncorrectInputException;
import com.divecursos.m3s1.exception.RecordFoundException;
import com.divecursos.m3s1.exception.RecordNotFoundException;
import com.divecursos.m3s1.model.entity.Course;
import com.divecursos.m3s1.model.repository.CourseRepository;
import com.divecursos.m3s1.model.repository.EnrollmentRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class CourseService {
    @Inject
    private CourseRepository courseRepository;
    @Inject
    private EnrollmentRepository enrollmentRepository;

    public Course create(Course course) {
        if (courseRepository.findByCode(course.getCode()).isPresent())
            throw new RecordFoundException("Curso", course.getCode());
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        if (!courseRepository.findByCode(course.getCode()).isPresent())
            throw new RecordNotFoundException("Curso", course.getCode());
        return courseRepository.merge(course);
    }

    public void deleteByCode(String code) {
        if (code == null || code.isEmpty())
            throw new IncorrectInputException("Curso", "código não informado");
        if (!courseRepository.findByCode(code).isPresent())
            throw new RecordNotFoundException("Curso", code);
        if (enrollmentRepository.findByCourseCode(code).size() > 0)
            throw new RecordFoundException("Curso", "Não pode ser excluído um curso que tenha matrículas");
        courseRepository.deleteByCode(code);
    }

    public List<Course> getAll(String sort, Integer limit) {
        if (sort != null && (!sort.equals("length") || !sort.equals("subject")))
            throw new IncorrectInputException("Sort", sort);
        List<Course> allCourses = courseRepository.getAll(sort, limit);
        if (allCourses.size() == 0)
            throw new RecordNotFoundException("Curso", "número de cursos");
        return allCourses;
    }

    public Course findByCode(String code) {
        if (code == null || code.isEmpty())
            throw new IncorrectInputException("Curso", "código não informado");
        Optional<Course> course = courseRepository.findByCode(code);
        if (!course.isPresent())
            throw new RecordNotFoundException("Curso", code);
        return course.get();
    }
}
