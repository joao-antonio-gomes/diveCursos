package com.divecursos.m3s1.model.repository;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

@RequestScoped
@Transactional
public class GenericRepository implements Serializable {

    @PersistenceContext(unitName = "diveCursos")
    protected EntityManager entityManager;

    public <T> T find(Class<T> clazz, Object pk) {
        return entityManager.find(clazz, pk);
    }

    public <T> void persist(T entity) {
        entityManager.persist(entity);
    }

    public <T> T merge(T entity) {
        return entityManager.merge(entity);
    }

    public <T> void remove(T entity) {
        entityManager.remove(entity);
    }

    public void flush() {
        entityManager.flush();
    }

    public <T> void refresh(T entity) {
        entityManager.refresh(entity);
    }

    public <T> T getReference(Class<T> clazz, Object pk) {
        return entityManager.getReference(clazz, pk);
    }

    public void clear() {
        entityManager.clear();
    }
}
