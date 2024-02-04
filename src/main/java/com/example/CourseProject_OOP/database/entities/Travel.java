package com.example.CourseProject_OOP.database.entities;

import com.example.CourseProject_OOP.enums.TransportType;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Travel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelId;

    @NotBlank(message = "Destination cannot be blank")
    private String destination;

    @NotNull(message = "Departure date cannot be null")
    private LocalDateTime departureDate;

    @NotNull(message = "Arrival date cannot be null")
    @Future(message = "Arrival date must be in the future")
    private LocalDateTime arrivalDate;

    @Min(value = 20, message = "Seats must be at least 20")
    private int seats;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Transport type cannot be null")
    private TransportType transportType;

    @Min(value = 1, message = "Purchase limit must be non-negative or at least 1")
    private int purchaseLimit;

}
