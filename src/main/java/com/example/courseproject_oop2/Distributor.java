package com.example.courseproject_oop2;

public class Distributor extends User{
    public Distributor(String username, String password, Role role) {
        super(username, password, role);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }
}
