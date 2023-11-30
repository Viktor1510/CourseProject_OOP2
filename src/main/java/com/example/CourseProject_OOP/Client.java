package com.example.CourseProject_OOP;

import jakarta.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    private String name;
    private double fare;

    public Client( String name, double fare) {
        this.name = name;
        this.fare = fare;
    }

    public Client() {

    }

    public String getName() {
        return name;
    }

    public double getFare() {
        return fare;
    }
}
