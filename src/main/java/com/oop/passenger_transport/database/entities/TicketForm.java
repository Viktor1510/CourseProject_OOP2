package com.oop.passenger_transport.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ticket_form")
@Getter
@Setter
public class TicketForm {
    @Id
    private Long id;

    @ManyToOne
    private User cashier;

    @ManyToOne
    private UserProfile userProfile;

    @OneToMany
    private List<Ticket> tickets;

    private LocalDateTime boughtAtDate;

    private LocalTime boughtAtTime;
}
