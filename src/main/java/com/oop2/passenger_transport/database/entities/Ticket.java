package com.oop2.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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


    @Column(name = "is_cancelled", nullable = false)
    private boolean cancelled;

    @Override
    public String toString() {
        return String.format("Ticket #%d | %s -> %s | Seat: %s | Cancelled: %b",
                id, trip.getOrganizer().getUsername(), trip.getDestination(), seatNumber, cancelled);
    }
}

