package com.example.courseproject_oop2;

public class TravelCompanyFactory implements UserAbstractFactory{

    private String username;
    private String password;

    public TravelCompanyFactory(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public User createUser(String username, String password) {
        return new TravelCompany(username,password,Role.TRAVELCOMPANY);
    }
}
