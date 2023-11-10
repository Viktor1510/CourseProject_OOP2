package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ratingId;
    @ManyToOne
    private User user;
    private Integer ratingValue;

    public Rating(User user, Integer ratingValue) {
        this.user = user;
        this.ratingValue = ratingValue;
    }

    public Rating() {

    }

    public UUID getRatingId() {
        return ratingId;
    }

    public User getUser() {
        return user;
    }

    public Integer getRatingValue() {
        return ratingValue;
    }
}
