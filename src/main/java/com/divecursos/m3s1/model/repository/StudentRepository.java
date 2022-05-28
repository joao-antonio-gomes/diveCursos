package com.divecursos.m3s1.model.repository;

import com.divecursos.m3s1.model.entity.Student;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class StudentRepository extends GenericRepository {
    public List<Student> findAll(String studentName) {
        String jpql = "select s from Student s";
        if (studentName != null && !studentName.isEmpty())
            jpql += " where s.name like :studentName";
        TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
        if (studentName != null && !studentName.isEmpty())
            query.setParameter("studentName", "%" + studentName + "%");
        return query.getResultList();
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
