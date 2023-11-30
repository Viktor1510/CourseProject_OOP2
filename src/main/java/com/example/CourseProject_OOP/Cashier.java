package com.example.CourseProject_OOP;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cashier extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cashierId;
    @OneToMany
    private Set<Distributor> distributors;
    public Cashier(String username, String password, Role role) {
        super(username, password, role);
    }

    public Cashier() {

    }

    public Long getCashierId() {
        return cashierId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return Objects.equals(cashierId, cashier.cashierId) && Objects.equals(distributors, cashier.distributors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cashierId, distributors);
    }
}
