package com.example.CourseProject_OOP;

import jakarta.persistence.*;


public class TravelCompanyFactory implements UserAbstractFactory{

    private String username;
    private String password;
    @ManyToOne
    private Distributor distributor;
    public TravelCompanyFactory(String username, String password) {
        this.username=username;
        this.password=password;

    }

    public TravelCompanyFactory() {

    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public User createUser(String username, String password) {
        return new TravelCompany(username,password,Role.TRAVELCOMPANY);
    }
}
