package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="user")
public abstract class User {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID user_id;
    private  String username;
    private  String password;
    private  Role role;

    public User(UUID id, String username, String password, Role role) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
