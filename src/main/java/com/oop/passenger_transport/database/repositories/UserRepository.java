    package com.oop.passenger_transport.database.repositories;


    import com.oop.passenger_transport.database.entities.User;
    import com.oop.passenger_transport.database.enums.Role;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.NoResultException;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    import java.time.Instant;
    import java.time.LocalDateTime;
    import java.time.ZoneId;
    import java.util.List;

    public class UserRepository extends AbstractRepository<User> {
        private  final Logger logger = LoggerFactory.getLogger(UserRepository.class);
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
        public List<User> findDistributorsByCreatedAtPeriod(LocalDateTime start, LocalDateTime end) {
            if (start == null || end == null) {
                throw new IllegalArgumentException("Start and end times cannot be null");
            }
            if (start.isAfter(end)) {
                throw new IllegalArgumentException("Start time cannot be after end time");
            }

            ZoneId zone = ZoneId.systemDefault();
            Instant startInstant = start.atZone(zone).toInstant();
            Instant endInstant = end.atZone(zone).toInstant();

            logger.info("Searching for distributors created between {} and {} (converted to Instant: {} - {})",
                    start, end, startInstant, endInstant);

            EntityManager em = getEntityManager();
            try {
                List<User> distributors = em.createQuery(
                                "SELECT u FROM User u WHERE u.role = :role AND u.createdAt BETWEEN :start AND :end ORDER BY u.createdAt ASC",
                                User.class)
                        .setParameter("role", Role.DISTRIBUTOR)
                        .setParameter("start", startInstant)
                        .setParameter("end", endInstant)
                        .getResultList();

                logger.info("Found {} distributors in the specified period", distributors.size());
                return distributors;
            } catch (Exception e) {
                logger.error("Error while querying distributors by period: {}", e.getMessage(), e);
                throw new RuntimeException("Failed to retrieve distributors: " + e.getMessage(), e);
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



        /**
         * Get a new EntityManager instance.
         */
        private EntityManager getEntityManager() {
            return emf.createEntityManager();
        }
    }

