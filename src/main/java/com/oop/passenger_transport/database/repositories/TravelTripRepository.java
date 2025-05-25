package com.oop.passenger_transport.database.repositories;



import com.oop.passenger_transport.database.entities.TravelTrip;
import com.oop.passenger_transport.database.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
public class TravelTripRepository extends AbstractRepository<TravelTrip> {
    private  final Logger logger = LoggerFactory.getLogger(TravelTripRepository.class);
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


    public List<TravelTrip> findByPeriod(LocalDateTime start, LocalDateTime end, boolean byDeparture) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end dates cannot be null");
        }

        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        EntityManager em = emf.createEntityManager();
        try {
            String field = byDeparture ? "departure" : "createdAt";

            TypedQuery<TravelTrip> query = em.createQuery(
                    "SELECT t FROM TravelTrip t WHERE t." + field + " BETWEEN :start AND :end ORDER BY t." + field + " ASC",
                    TravelTrip.class);
            query.setParameter("start", start);
            query.setParameter("end", end);

            return query.getResultList();
        } finally {
            em.close();
        }
    }


    public List<TravelTrip> findByOrganizerAndPeriod(User organizer, LocalDateTime start, LocalDateTime end) {
        if (organizer == null) {
            throw new IllegalArgumentException("Organizer cannot be null");
        }
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end dates cannot be null");
        }
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        logger.info("Fetching travel trips for organizer {} from {} to {}", organizer.getUsername(), start, end);

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TravelTrip> query = em.createQuery(
                    "SELECT t FROM TravelTrip t WHERE t.organizer = :organizer AND t.createdAt BETWEEN :start AND :end ORDER BY t.createdAt ASC",
                    TravelTrip.class);
            query.setParameter("organizer", organizer);
            query.setParameter("start", start);
            query.setParameter("end", end);

            List<TravelTrip> trips = query.getResultList();
            logger.info("Found {} travel trips for organizer {}", trips.size(), organizer.getUsername());

            return trips;
        } catch (Exception e) {
            logger.error("Error fetching travel trips: {}", e.getMessage(), e);
            throw new RuntimeException("Error fetching travel trips: " + e.getMessage(), e);
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

