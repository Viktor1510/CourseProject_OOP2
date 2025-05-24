package com.oop.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

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

    private String firstName;

    private String secondName;

    private String lastName;

    private String EGN;

    @Column(name = "honorarium")
    private Double honorarium;

}

