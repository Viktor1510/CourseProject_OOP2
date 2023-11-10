package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="TravelCompany")
public class TravelCompany extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID companyId;
    public TravelCompany(String username, String password, Role role) {
        super(username, password, role);
    }

    public TravelCompany() {

    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }
}
