package com.oop2.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profile_ratings")
public class UserProfileRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserProfile rater;


    @ManyToOne
    private User ratedUser;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Double weightCoefficient;

    @Column(nullable = false)
    private LocalDateTime ratedAt;


    @PrePersist
    public void prePersist() {
        this.ratedAt = LocalDateTime.now();
        this.weightCoefficient = calculateWeightCoefficient();
    }

    private double calculateWeightCoefficient() {
        double base = 1.0;

        if (rater == null) return base;

        boolean highHonorarium = rater.getHonorarium() != null && rater.getHonorarium() > 1000;
        boolean activeSales = rater.getTickets() != null && rater.getTickets().size() > 10;

        if (highHonorarium && activeSales) {
            return 3.0;
        } else if (highHonorarium) {
            return 2.0;
        } else if (activeSales) {
            return 1.0;
        }

        return base;
    }





}


