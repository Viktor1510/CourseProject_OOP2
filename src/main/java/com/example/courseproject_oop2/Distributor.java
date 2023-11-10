package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Distributor")
public class Distributor extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID distributorId;
    @OneToMany
    private Set<TravelCompany> companies;

    public Distributor(String username, String password, Role role) {
        super(username, password, role);
    }

    public Distributor() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distributor that = (Distributor) o;
        return Objects.equals(distributorId, that.distributorId) && Objects.equals(companies, that.companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distributorId, companies);
    }
}
