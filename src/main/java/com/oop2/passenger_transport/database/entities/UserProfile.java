package com.oop2.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "honorarium")
    private Double honorarium;

    @Column(name = "rating")
    private Double rating;

    @OneToMany
    private List<Ticket> tickets;

    @OneToMany
    private List<Notification> notifications;
}

