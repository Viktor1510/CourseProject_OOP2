package com.example.CourseProject_OOP;

import jakarta.persistence.*;

@Entity
@Table(name="Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingId;
    @ManyToOne
    private User user;
    private Integer ratingValue;

    public Rating(User user, Integer ratingValue) {
        this.user = user;
        this.ratingValue = ratingValue;
    }

    public Rating() {

    }

    public Long getRatingId() {
        return ratingId;
    }

    public User getUser() {
        return user;
    }

    public Integer getRatingValue() {
        return ratingValue;
    }
}
