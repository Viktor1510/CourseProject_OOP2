package com.example.CourseProject_OOP;


public class Admin extends User{

    public Admin(String username, String password, Role role) {
        super(username, password, role);
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }
}
