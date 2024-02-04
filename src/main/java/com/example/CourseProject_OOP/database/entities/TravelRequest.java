package com.example.CourseProject_OOP.database.entities;

import com.example.CourseProject_OOP.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "travel_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelRequestId;

    @NotNull(message = "Status cannot be null")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "User cannot be null")
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @NotNull(message = "Travel cannot be null")
    @ManyToOne
    @JoinColumn(name = "travelId")
    private Travel travel;
}
