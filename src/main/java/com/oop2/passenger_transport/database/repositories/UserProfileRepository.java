package com.oop2.passenger_transport.database.repositories;


import com.oop2.passenger_transport.database.entities.User;
import com.oop2.passenger_transport.database.entities.UserProfile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserProfileRepository extends AbstractRepository<UserProfile> {

    @Override
    protected Class<UserProfile> getEntityClass() {
        return UserProfile.class;
    }

    public UserProfile findByUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<UserProfile> query = em.createQuery(
                    "SELECT up FROM UserProfile up WHERE up.user = :user", UserProfile.class);
            query.setParameter("user", user);
            return query.getResultStream().findFirst().orElse(null);
        } finally {
            em.close();
        }
    }
}
