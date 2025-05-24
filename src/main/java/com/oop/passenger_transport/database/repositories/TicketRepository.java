package com.oop.passenger_transport.database.repositories;


import com.oop.passenger_transport.database.entities.Ticket;
import com.oop.passenger_transport.database.entities.TravelTrip;
import com.oop.passenger_transport.database.entities.User;
import com.oop.passenger_transport.database.entities.UserProfile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;

public class TicketRepository extends AbstractRepository<Ticket> {

    @Override
    protected Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    public List<Ticket> findByCashier(User cashier) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Ticket> query = em.createQuery(
                    "SELECT t FROM Ticket t WHERE t.cashier = :cashier ORDER BY t.saleDate DESC", Ticket.class);
            query.setParameter("cashier", cashier);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Ticket> findByUserProfile(UserProfile profile) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Ticket> query = em.createQuery(
                    "SELECT t FROM Ticket t WHERE t.userProfile = :profile ORDER BY t.saleDate DESC", Ticket.class);
            query.setParameter("profile", profile);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Ticket> findByTrip(TravelTrip trip) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Ticket> query = em.createQuery(
                    "SELECT t FROM Ticket t WHERE t.trip = :trip ORDER BY t.saleDate DESC", Ticket.class);
            query.setParameter("trip", trip);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Ticket> findCancelledTickets() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Ticket> query = em.createQuery(
                    "SELECT t FROM Ticket t WHERE t.cancelled = true ORDER BY t.saleDate DESC", Ticket.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Ticket> findSoldBetween(LocalDateTime from, LocalDateTime to) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Ticket> query = em.createQuery(
                    "SELECT t FROM Ticket t WHERE t.saleDate BETWEEN :from AND :to ORDER BY t.saleDate DESC", Ticket.class);
            query.setParameter("from", from);
            query.setParameter("to", to);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

