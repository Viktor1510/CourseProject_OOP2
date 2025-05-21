package com.oop2.passenger_transport.database.repositories;

import com.oop2.passenger_transport.database.entities.TicketRequest;
import com.oop2.passenger_transport.database.entities.TravelTrip;
import com.oop2.passenger_transport.database.entities.User;
import com.oop2.passenger_transport.database.enums.RequestStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TicketRequestRepository extends AbstractRepository<TicketRequest> {

    @Override
    protected Class<TicketRequest> getEntityClass() {
        return TicketRequest.class;
    }

    public List<TicketRequest> findByDistributor(User distributor) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TicketRequest> query = em.createQuery(
                    "SELECT r FROM TicketRequest r WHERE r.distributor = :distributor ORDER BY r.id DESC",
                    TicketRequest.class);
            query.setParameter("distributor", distributor);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TicketRequest> findByTrip(TravelTrip trip) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TicketRequest> query = em.createQuery(
                    "SELECT r FROM TicketRequest r WHERE r.trip = :trip ORDER BY r.id DESC",
                    TicketRequest.class);
            query.setParameter("trip", trip);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TicketRequest> findByStatus(RequestStatus status) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TicketRequest> query = em.createQuery(
                    "SELECT r FROM TicketRequest r WHERE r.status = :status ORDER BY r.id DESC",
                    TicketRequest.class);
            query.setParameter("status", status);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TicketRequest> findPendingByDistributor(User distributor) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TicketRequest> query = em.createQuery(
                    "SELECT r FROM TicketRequest r WHERE r.distributor = :distributor AND r.status = :status ORDER BY r.id DESC",
                    TicketRequest.class);
            query.setParameter("distributor", distributor);
            query.setParameter("status", RequestStatus.PENDING);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
