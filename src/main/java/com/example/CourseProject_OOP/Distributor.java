package com.example.CourseProject_OOP;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Distributor extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long distributorId;
    @OneToMany
    private Set<TravelCompany> companies;

    public Distributor(String username, String password, Role role) {
        super(username, password, role);
    }

    public Distributor() {

    }

    public Long getDistributorId() {
        return distributorId;
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
