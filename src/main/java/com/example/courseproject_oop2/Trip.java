package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tripId;
    @ManyToOne
    private TravelCompany travelCompany;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private Integer availableSeats;
    private String transportType;
    private String otherDetails;

    public Trip(TravelCompany travelCompany, String destination, Date departureDate, Date arrivalDate, Integer availableSeats, String transportType, String otherDetails) {
        this.travelCompany = travelCompany;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.availableSeats = availableSeats;
        this.transportType = transportType;
        this.otherDetails = otherDetails;
    }

    public Trip() {

    }

    public UUID getTripId() {
        return tripId;
    }

    public TravelCompany getTravelCompany() {
        return travelCompany;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public String getTransportType() {
        return transportType;
    }

    public String getOtherDetails() {
        return otherDetails;
    }
}
