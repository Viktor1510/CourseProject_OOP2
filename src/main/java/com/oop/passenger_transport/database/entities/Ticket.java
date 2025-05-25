package com.oop.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cashier_id", nullable = false)
    private User cashier;

    @ManyToOne
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private TravelTrip trip;

    @Column(name = "seat_number", nullable = false, length = 8)
    private String seatNumber;


    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @Column(name = "departure_time")
    private LocalDateTime departure;

    @Column(name = "arrival_time")
    private LocalDateTime arrival;

    private LocalTime hourArrival;

    private LocalTime saleTime;

    private Integer saleCount;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
}

