package com.oop2.passenger_transport.database.repositories;


import com.oop2.passenger_transport.database.entities.TicketSale;
import com.oop2.passenger_transport.database.entities.TravelTrip;
import com.oop2.passenger_transport.database.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TicketSaleRepository extends AbstractRepository<TicketSale> {

    @Override
    protected Class<TicketSale> getEntityClass() {
        return TicketSale.class;
    }

    public List<TicketSale> findByCashier(User cashier) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TicketSale> query = em.createQuery(
                    "SELECT ts FROM TicketSale ts WHERE ts.cashier = :cashier ORDER BY ts.saleDate DESC", TicketSale.class);
            query.setParameter("cashier", cashier);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TicketSale> findByTrip(TravelTrip trip) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TicketSale> query = em.createQuery(
                    "SELECT ts FROM TicketSale ts WHERE ts.trip = :trip ORDER BY ts.saleDate DESC", TicketSale.class);
            query.setParameter("trip", trip);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TicketSale> findActiveSales() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TicketSale> query = em.createQuery(
                    "SELECT ts FROM TicketSale ts WHERE ts.isCancelled = false ORDER BY ts.saleDate DESC", TicketSale.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TicketSale> findCancelledSales() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TicketSale> query = em.createQuery(
                    "SELECT ts FROM TicketSale ts WHERE ts.isCancelled = true ORDER BY ts.saleDate DESC", TicketSale.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

