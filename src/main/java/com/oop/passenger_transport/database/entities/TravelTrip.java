package com.oop.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "travel_trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer; // TravelCompany

    private String destination;

    private int seatCount;

    private String transportType;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "ticket_limit_per_user")
    private int ticketLimit;

}

