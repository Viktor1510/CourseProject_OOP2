package com.example.courseproject_oop2;

public class CashierFactory implements UserAbstractFactory{
    @Override
    public User createUser(String username, String password) {
        return new Cashier(username,password,Role.CASHIER);
    }
}
