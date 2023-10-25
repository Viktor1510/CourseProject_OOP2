package com.example.courseproject_oop2;

public class Admin extends User {

    public Admin(String username, String password, Role role) {
        super(username, password, role);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }
}
