package com.example.CourseProject_OOP;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TravelCompany extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;
    public TravelCompany(String username, String password, Role role) {
        super(username, password, role);
    }

    public TravelCompany() {

    }

    public Long getCompanyId() {
        return companyId;
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
