package com.example.CourseProject_OOP.database.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketId;

    @NotNull(message = "Purchase date cannot be empty.")
    private LocalDateTime purchaseDate;

    @ManyToOne
    @JoinColumn(name = "travelId")
    @NotNull(message = "Travel cannot be empty.")
    private Travel travel;

    @ManyToOne
    @JoinColumn(name = "clientProfileId")
    @NotNull(message = "Client profile cannot be empty.")
    private ClientProfile clientProfile;
}