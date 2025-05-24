package com.oop.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

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


    @Column(name = "ticket_limit_per_user")
    private int ticketLimit;
}

