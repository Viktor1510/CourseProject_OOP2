package com.example.courseproject_oop2;

public class CashierFactory implements UserAbstractFactory{

    private String username;
    private String password;

    public CashierFactory(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public User createUser(String username, String password) {
        return new Cashier(username,password,Role.CASHIER);
    }
}
