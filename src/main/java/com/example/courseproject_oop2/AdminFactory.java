package com.example.courseproject_oop2;

public class AdminFactory implements UserAbstractFactory {

    private String username;
    private String password;

    public AdminFactory(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public User createUser(String username, String password) {
        return new Admin(username,password,Role.ADMIN);
    }
}
