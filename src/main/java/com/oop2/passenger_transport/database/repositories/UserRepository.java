package com.oop2.passenger_transport.database.repositories;


import com.oop2.passenger_transport.database.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class UserRepository extends AbstractRepository<User> {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    /**
     * Find a user by username (unique).
     * @param username The username to search for.
     * @return The User if found, otherwise null.
     */
    public User findByUsername(String username) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Delete user by username (if needed).
     */
    public void deleteByUsername(String username) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            User user = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            em.remove(user);
            em.getTransaction().commit();
        } catch (NoResultException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    // Може да добавиш и други специфични заявки тук...

    /**
     * Get a new EntityManager instance.
     */
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

