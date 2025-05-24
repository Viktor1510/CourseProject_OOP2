package com.oop.passenger_transport.database.repositories;


import com.oop.passenger_transport.database.entities.TravelTrip;
import com.oop.passenger_transport.database.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;

public class TravelTripRepository extends AbstractRepository<TravelTrip> {

    @Override
    protected Class<TravelTrip> getEntityClass() {
        return TravelTrip.class;
    }


    public List<TravelTrip> findByOrganizer(User organizer) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TravelTrip> query = em.createQuery(
                    "SELECT t FROM TravelTrip t WHERE t.organizer = :organizer ORDER BY t.departure ASC", TravelTrip.class);
            query.setParameter("organizer", organizer);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    public List<TravelTrip> findByDestination(String destination) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TravelTrip> query = em.createQuery(
                    "SELECT t FROM TravelTrip t WHERE t.destination LIKE :dest ORDER BY t.departure ASC", TravelTrip.class);
            query.setParameter("dest", "%" + destination + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    public List<TravelTrip> findByDepartureBetween(LocalDateTime start, LocalDateTime end) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TravelTrip> query = em.createQuery(
                    "SELECT t FROM TravelTrip t WHERE t.departure BETWEEN :start AND :end ORDER BY t.departure ASC", TravelTrip.class);
            query.setParameter("start", start);
            query.setParameter("end", end);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

