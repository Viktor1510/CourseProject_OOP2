package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Distributor")
public class Distributor extends User{
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID distributor_id;
    @OneToMany
    private Set<TravelCompany> companies;

    public Distributor(String username, String password, Role role) {
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
        Distributor that = (Distributor) o;
        return Objects.equals(distributor_id, that.distributor_id) && Objects.equals(companies, that.companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distributor_id, companies);
    }
}
