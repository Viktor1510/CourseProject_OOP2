package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID clientId;
    private String name;
    private double fare;

    public Client(String name, double fare) {
        this.name = name;
        this.fare = fare;
    }
}
