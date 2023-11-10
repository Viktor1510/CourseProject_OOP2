package com.example.courseproject_oop2;

public class DistributorFactory implements UserAbstractFactory{
    private String username;
    private String password;

    public DistributorFactory(String username, String password) {
       this.password=password;
       this.username=username;
    }

    @Override
    public User createUser(String username, String password) {
        return new Cashier(username,password,Role.DISTRIBUTOR);
    }
}
