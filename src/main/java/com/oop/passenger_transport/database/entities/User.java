package com.oop.passenger_transport.database.entities;

import com.oop.passenger_transport.database.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The {@code User} class represents a system user with a unique identifier, username, password, and role.
 * <p>
 * This class is annotated with JPA annotations for entity mapping and is designed to be used with a
 * relational database.
 * @see Table
 * @see Column
 * @see GeneratedValue
 * @see GenerationType
 * @see Enumerated
 * @see lombok.Getter
 * @see lombok.Setter
 * @see lombok.Builder
 * @see lombok.AllArgsConstructor
 * @see lombok.NoArgsConstructor
 */
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "users")
@AllArgsConstructor
public class User  {
    /**
     * The unique identifier for the user.
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username of the user (unique constraint, not nullable).
     */
    @Column(name = "username", length = 32, unique = true, nullable = false)
    private String username;

    /**
     * The password of the user (not nullable).
     */
    @Column(name = "password", length = 1024, nullable = false)
    private String password;

    /**
     * The role of the user.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 16, nullable = false)
    private Role role;

    private Double honorarium;
    /**
     * The list of event notifications associated with the user.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> eventNotifications;

    private LocalDateTime createdAt;
    /**
     * Overrides the default {@code toString()} method to provide a formatted string representation
     * of the user's information.
     *
     * @return A string representation of the user.
     */
    @Override
    public String toString() {
        return String.format("Id: %d, Username: %s, Role: %s",
                id, username, role.getRole());
    }
}