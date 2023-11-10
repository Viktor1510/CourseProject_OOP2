package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="cashier")
public class Cashier extends User{

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID cashier_id;

    @OneToMany
    private Set<Distributor> distributors;
    public Cashier(String username, String password, Role role) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return Objects.equals(cashier_id, cashier.cashier_id) && Objects.equals(distributors, cashier.distributors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cashier_id, distributors);
    }
}
