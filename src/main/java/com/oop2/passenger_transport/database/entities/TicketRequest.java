package com.oop2.passenger_transport.database.entities;

import com.oop2.passenger_transport.database.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.*;

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
}
