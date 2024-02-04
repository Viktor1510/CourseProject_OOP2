package com.example.CourseProject_OOP.database.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name = "ClientProfile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientProfileId;

    @DecimalMin(value = "0.0", inclusive = false, message = "Honorarium must be greater than 0.")
    @DecimalMax(value = "10000.0", message = "Honorarium must be less than or equal to 10000.")
    private BigDecimal honorarium;

    @NotBlank(message = "First name cannot be blank.")
    private String firstName;

    @NotBlank(message = "Second name cannot be blank.")
    private String secondName;

    @NotBlank(message = "Last name cannot be blank.")
    private String lastName;

    @Min(value = 18, message = "Age must be at least 18.")
    private int age;

    @NotBlank(message = "Country cannot be blank.")
    private String country;
}
