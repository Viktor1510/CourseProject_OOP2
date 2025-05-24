package com.oop.passenger_transport.database.repositories;

import com.oop.passenger_transport.database.entities.Notification;
import com.oop.passenger_transport.database.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;

public class NotificationRepository extends AbstractRepository<Notification> {

    @Override
    protected Class<Notification> getEntityClass() {
        return Notification.class;
    }

    /**
     * Finds all notifications for a specific user.
     * @param user The user whose notifications are being retrieved.
     * @return List of notifications.
     */
    public List<Notification> findByUser(User user) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Notification> query = em.createQuery(
                    "SELECT n FROM Notification n WHERE n.user = :user ORDER BY n.timestamp DESC",
                    Notification.class);
            query.setParameter("user", user);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Finds all notifications after a given timestamp.
     * @param fromTime The start time.
     * @return List of notifications created after the specified time.
     */
    public List<Notification> findByTimestampAfter(LocalDateTime fromTime) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Notification> query = em.createQuery(
                    "SELECT n FROM Notification n WHERE n.timestamp > :fromTime ORDER BY n.timestamp DESC",
                    Notification.class);
            query.setParameter("fromTime", fromTime);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Deletes all notifications for a given user.
     * @param user The user whose notifications will be deleted.
     */
    public void deleteAllByUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("DELETE FROM Notification n WHERE n.user = :user")
                    .setParameter("user", user)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

