package com.divecursos.m3s1.model.repository;

import com.divecursos.m3s1.model.entity.Student;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class StudentRepository extends GenericRepository {
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Optional<Student> findByRegister(Integer register) {
        String jpql = "SELECT s FROM Student s WHERE s.register = :register";
        try {
            return Optional.of(entityManager.createQuery(jpql, Student.class)
                    .setParameter("register", register)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Student save(Student student) {
        return entityManager.merge(student);
    }

    public void deleteByRegister(Integer register) {
        Student student = entityManager.find(Student.class, register);
        entityManager.remove(student);
    }

    public Student update(Student student) {
        return entityManager.merge(student);
    }

}
