package com.example.courseproject_oop2;

import java.util.UUID;

public class Admin extends User {

    public Admin(UUID id, String username, String password, Role role) {
        super(id, username, password, role);
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
