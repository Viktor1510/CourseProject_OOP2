package com.example.CourseProject_OOP;

import jakarta.persistence.*;

@Entity
@Table(name="ticketRequests")
public class TicketRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long requestId;

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


    public TicketRequest() {

    }

    public Long getRequestId() {
        return requestId;
    }

    public String getStatus() {
        return status;
    }

    public Trip getTrip() {
        return trip;
    }


}
