package com.example.courseproject_oop2;

public class DistributorFactory implements UserAbstractFactory{

    private String username;
    private String password;

    public DistributorFactory(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public User createUser(String username, String password) {
        return new Distributor(username,password,Role.DISTRIBUTOR);
    }
}
