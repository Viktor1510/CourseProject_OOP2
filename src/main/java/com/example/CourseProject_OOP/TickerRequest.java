package com.example.CourseProject_OOP;

import jakarta.persistence.*;

@Entity
@Table(name="TicketRequest")
public class TickerRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestId;
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

    public Long getRequestId() {
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
