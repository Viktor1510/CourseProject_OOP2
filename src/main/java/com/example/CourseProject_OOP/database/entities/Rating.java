package com.example.CourseProject_OOP.database.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Rating")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull(message = "User cannot be null.")
    private User user;

    @Min(value = 1, message = "Rating value must be at least 1.")
    @Max(value = 5, message = "Rating value must not exceed 5.")
    private int ratingValue;

    @Min(value = 0, message = "Current value must be at least 0.")
    private int currentValue;
}
