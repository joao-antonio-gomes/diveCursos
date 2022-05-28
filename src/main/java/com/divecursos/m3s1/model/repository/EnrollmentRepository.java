package com.divecursos.m3s1.model.repository;

import com.divecursos.m3s1.model.entity.Enrollment;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class EnrollmentRepository extends GenericRepository {
    public List<Enrollment> findAll() {
        return entityManager.createQuery("SELECT e FROM Enrollment e", Enrollment.class).getResultList();
    }

    public Optional<Enrollment> findById(String id) {
        String jpql = "SELECT e FROM Enrollment e WHERE e.id = :id";
        try {
            return Optional.of(entityManager.createQuery(jpql, Enrollment.class)
                    .setParameter("id", id)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Enrollment save(Enrollment enrollment) {
        return entityManager.merge(enrollment);
    }

    public void deleteById(String id) {
        Enrollment enrollment = entityManager.find(Enrollment.class, id);
        entityManager.remove(enrollment);
    }

    public Enrollment update(Enrollment enrollment) {
        return entityManager.merge(enrollment);
    }
}