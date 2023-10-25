package com.example.courseproject_oop2;

public class AdminFactory implements UserAbstractFactory {
    @Override
    public User createUser(String username, String password) {
        return new Admin(username,password,Role.ADMIN);
    }
}
