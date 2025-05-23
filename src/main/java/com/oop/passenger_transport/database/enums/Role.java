package com.oop.passenger_transport.database.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The {@code Role} enum represents different roles that users can have in a library system.
 * Each role has a corresponding display value, indicating the level of access or authority
 * associated with that role. The enum provides two roles: "Admin" and "Operator."
 *
 * @see lombok.Getter
 * @see lombok.AllArgsConstructor
 */
@Getter
public enum Role {
    /**
     * Administrator role with full access and authority.
     */
    ADMIN("Admin"),

    /**
     * Cashier role with limited access and authority.
     */
    CASHIER("Cashier"),

    /**
     * Travel company role with limited access and authority.
     */
    TRAVELCOMPANY("TravelCompany"),

    /**
     * Distributor role with limited access and authority.
     */
    DISTRIBUTOR("Distributor");

    /**
     * The display value of the role.
     */
    private final String role;

    Role(String role) {
        this.role = role;
    }
}
