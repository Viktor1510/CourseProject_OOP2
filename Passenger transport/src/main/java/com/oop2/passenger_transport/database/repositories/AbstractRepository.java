package com.oop2.passenger_transport.database.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public abstract class AbstractRepository<T> {

    protected static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("transport_persistence_unit");

    protected abstract Class<T> getEntityClass();

    public void save(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void update(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Object id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T entity = em.find(getEntityClass(), id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }

    public T findById(Object id) {
        EntityManager em = emf.createEntityManager();
        T entity = em.find(getEntityClass(), id);
        em.close();
        return entity;
    }

    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        List<T> result = em.createQuery("SELECT e FROM " + getEntityClass().getSimpleName() + " e", getEntityClass())
                .getResultList();
        em.close();
        return result;
    }
}
