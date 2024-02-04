package com.example.CourseProject_OOP.database.entities;

import com.example.CourseProject_OOP.enums.NotificationType;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@Table(name = "Notification")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Notification type cannot be null.")
    private NotificationType type;

    @NotBlank(message = "Notification content cannot be blank.")
    private String content;

    @PastOrPresent(message = "Notification date must be in the past or present.")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull(message = "User cannot be null.")
    private User user;
}
