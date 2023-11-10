package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="ticketRequests")
public class TicketRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID requestId;

    @ManyToOne
    private Distributor distributor;
    @ManyToOne
    private Trip trip;

    private String status;

    public TicketRequest(Distributor distributor, Trip trip, String status) {
        this.distributor = distributor;
        this.trip = trip;
        this.status = status;
    }


}
