package com.divecursos.m3s1.model.repository;

import com.divecursos.m3s1.model.entity.Course;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CourseRepository extends GenericRepository {
    public List<Course> getAll(String sort, Integer limit) {
        String jpql = "SELECT c FROM Course c";
        if (sort != null)
            jpql += " ORDER BY c." + sort;
        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
        if (limit != null)
            query.setMaxResults(limit);
        return query.getResultList();
    }

    public Optional<Course> findByCode(String code) {
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
