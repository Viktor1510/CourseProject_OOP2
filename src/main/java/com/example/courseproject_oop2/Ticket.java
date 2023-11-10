package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private UUID ticketId;
    @ManyToOne
    private Cashier cashier;
    @ManyToOne
    private Client client;

    private Date purchaseDate;

    private Integer seatNumber;
    @ManyToOne
    private Trip trip;

    public Ticket( Cashier cashier, Client client, Date purchaseDate, Integer seatNumber,Trip trip) {
        this.cashier = cashier;
        this.client = client;
        this.purchaseDate = purchaseDate;
        this.seatNumber = seatNumber;
        this.trip=trip;
    }

    public Ticket() {

    }

    public UUID getTicketId() {
        return ticketId;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public Client getClient() {
        return client;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }
}
