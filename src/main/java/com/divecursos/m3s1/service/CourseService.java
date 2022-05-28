package com.divecursos.m3s1.service;

import com.divecursos.m3s1.exception.IncorrectInputException;
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
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        return courseRepository.merge(course);
    }

    public void deleteByCode(String code) throws IncorrectInputException, RecordNotFoundException {
        if (!courseRepository.findByCourse(code).isPresent())
            throw new RecordNotFoundException("Course", code);
        if (enrollmentRepository.findByCourseCode(code).size() > 0)
            throw new IncorrectInputException("Course", "Cannot delete a course with enrollments");
        courseRepository.deleteByCode(code);
    }

    public List<Course> findAll(String sort, Integer limit) throws IncorrectInputException {
        if (sort != null && !sort.equals("assunto") && !sort.equals("duracao"))
            throw new IncorrectInputException("Sort", sort);
        return courseRepository.findAll(sort, limit);
    }

    public Course findByCode(String code) throws RecordNotFoundException {
        Optional<Course> course = courseRepository.findByCourse(code);
        if (!course.isPresent())
            throw new RecordNotFoundException("Course", code);
        return course.get();
    }
}
