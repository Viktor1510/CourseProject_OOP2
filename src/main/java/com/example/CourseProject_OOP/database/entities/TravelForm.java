package com.example.CourseProject_OOP.database.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TravelForm")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelFormId;

    @NotNull(message = "Creation date cannot be null")
    private LocalDateTime creationDate;

    @NotNull(message = "Expiration date cannot be null")
    @Future(message = "Expiration date must be in the future")
    private LocalDateTime expirationDate;

    @NotNull(message = "Client profile cannot be null")
    @ManyToOne
    @JoinColumn(name = "clientProfileId")
    private ClientProfile clientProfile;

    @NotNull(message = "Tickets cannot be null")
    @ManyToMany
    @JoinTable(
            name = "TravelFormTickets",
            joinColumns = @JoinColumn(name = "travelFormId"),
            inverseJoinColumns = @JoinColumn(name = "ticketId")
    )
    private List<Ticket> tickets;
}
