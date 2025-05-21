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

    /**
     * Касиерът, който е продал билета.
     */
    @ManyToOne
    @JoinColumn(name = "cashier_id", nullable = false)
    private User cashier;

    @ManyToOne
    private UserProfile userProfile;
    /**
     * Пътуването, за което е закупен билета.
     */
    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private TravelTrip trip;

    /**
     * Името на купувача.
     */
    @Column(name = "buyer_name", nullable = false, length = 64)
    private String buyerName;

    /**
     * Номер на мястото.
     */
    @Column(name = "seat_number", nullable = false, length = 8)
    private String seatNumber;

    /**
     * Дата и час на покупка.
     */
    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    /**
     * Статус на билета – валиден или анулиран.
     */
    @Column(name = "is_cancelled", nullable = false)
    private boolean cancelled;

    @Override
    public String toString() {
        return String.format("Ticket #%d | %s -> %s | Buyer: %s | Seat: %s | Cancelled: %b",
                id, trip.getOrganizer().getUsername(), trip.getDestination(),
                buyerName, seatNumber, cancelled);
    }
}

