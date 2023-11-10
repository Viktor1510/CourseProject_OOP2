package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="TicketRequest")
public class TickerRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID requestId;
    @ManyToOne
    private  Distributor distributor;
    @ManyToOne
    private  Trip trip;

    private String status;

    public TickerRequest(Distributor distributor, Trip trip, String status) {
        this.distributor = distributor;
        this.trip = trip;
        this.status = status;
    }

    public TickerRequest() {

    }

    public UUID getRequestId() {
        return requestId;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public Trip getTrip() {
        return trip;
    }

    public String getStatus() {
        return status;
    }
}
