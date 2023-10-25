package com.example.courseproject_oop2;

public class TravelCompanyFactory implements UserAbstractFactory{
    @Override
    public User createUser(String username, String password) {
        return new TravelCompany(username,password,Role.TRAVELCOMPANY);
    }
}
