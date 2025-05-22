package com.oop2.passenger_transport.database.repositories;


import com.oop2.passenger_transport.database.entities.UserProfileRating;
import com.oop2.passenger_transport.database.enums.Ratings;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserProfileRatingRepository extends AbstractRepository<UserProfileRating> {

    @Override
    protected Class<UserProfileRating> getEntityClass() {
        return UserProfileRating.class;
    }

    /**
     * Намира всички UserProfileRating с дадена стойност на рейтинга.
     */
    public List<UserProfileRating> findByRating(Ratings rating) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<UserProfileRating> query = em.createQuery(
                    "SELECT upr FROM UserProfileRating upr WHERE upr.rating = :rating", UserProfileRating.class);
            query.setParameter("rating", rating);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
