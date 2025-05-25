package com.oop.passenger_transport.database.entities;

import com.oop.passenger_transport.database.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "ticket_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private User distributor;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TravelTrip trip;

    @Enumerated(EnumType.STRING)
    private RequestStatus status; // PENDING, APPROVED, REJECTED

    @Column(nullable = false,updatable = false)
    private Instant createdAt;
}
