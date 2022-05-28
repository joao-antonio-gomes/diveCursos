package com.divecursos.m3s1.model.repository;

import com.divecursos.m3s1.model.entity.Course;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class CourseRepository extends GenericRepository {
    public List<Course> findAll(String sort, Integer limit) {
        String jpql = "SELECT c FROM Course c";
        if (sort != null)
            jpql += " ORDER BY c." + sort;
        if (limit != null)
            jpql += " LIMIT " + limit;
        return entityManager.createQuery(jpql, Course.class).getResultList();
    }

    public Optional<Course> findByCourse(String code) {
        String jpql = "SELECT c FROM Course c WHERE c.code = :code";
        try {
            return Optional.of(entityManager.createQuery(jpql, Course.class)
                    .setParameter("code", code)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Course save(Course course) {
        return entityManager.merge(course);
    }

    public void deleteByCode(String code) {
        Course course = entityManager.find(Course.class, code);
        entityManager.remove(course);
    }

    public Course update(Course course) {
        return entityManager.merge(course);
    }
}
