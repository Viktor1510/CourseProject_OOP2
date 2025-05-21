package com.oop2.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User cashier;

    @ManyToOne
    private TravelTrip trip;

    @ManyToOne
    private UserProfile userProfile;

    private String buyerName;

    private String seatNumber;

    private LocalDateTime saleDate;

    private boolean isCancelled;


}

