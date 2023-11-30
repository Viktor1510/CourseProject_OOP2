package com.example.CourseProject_OOP;

public class CashierFactory implements UserAbstractFactory{
    private String username;
    private String password;

    public CashierFactory(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public User createUser(String username, String password) {
        return new Cashier(username,password,Role.CASHIER);
    }
}
