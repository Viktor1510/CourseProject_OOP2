package com.oop.passenger_transport.database.repositories;


import com.oop.passenger_transport.database.entities.TicketForm;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;

public class TicketFormRepository extends AbstractRepository<TicketForm> {

    @Override
    protected Class<TicketForm> getEntityClass() {
        return TicketForm.class;
    }

    public List<TicketForm> findByCashierId(Long cashierId) {
        EntityManager em = emf.createEntityManager();
        List<TicketForm> result = em.createQuery(
                        "SELECT tf FROM TicketForm tf WHERE tf.cashier.id = :cashierId", TicketForm.class)
                .setParameter("cashierId", cashierId)
                .getResultList();
        em.close();
        return result;
    }

    public List<TicketForm> findByUserProfileId(Long userProfileId) {
        EntityManager em = emf.createEntityManager();
        List<TicketForm> result = em.createQuery(
                        "SELECT tf FROM TicketForm tf WHERE tf.userProfile.id = :userProfileId", TicketForm.class)
                .setParameter("userProfileId", userProfileId)
                .getResultList();
        em.close();
        return result;
    }

    public List<TicketForm> findByBoughtAtDateBetween(LocalDateTime start, LocalDateTime end) {
        EntityManager em = emf.createEntityManager();
        List<TicketForm> result = em.createQuery(
                        "SELECT tf FROM TicketForm tf WHERE tf.boughtAtDate BETWEEN :start AND :end", TicketForm.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
        em.close();
        return result;
    }

    public long countTicketFormsByCashierId(Long cashierId) {
        EntityManager em = emf.createEntityManager();
        Long count = em.createQuery(
                        "SELECT COUNT(tf) FROM TicketForm tf WHERE tf.cashier.id = :cashierId", Long.class)
                .setParameter("cashierId", cashierId)
                .getSingleResult();
        em.close();
        return count;
    }
}

