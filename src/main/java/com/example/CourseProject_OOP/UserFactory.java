package com.example.CourseProject_OOP;

public class UserFactory {
    public UserAbstractFactory createUser(String username, String password,Role role)
    {
        return switch (role) {
            case ADMIN -> new AdminFactory(username, password);
            case CASHIER -> new CashierFactory(username, password);
            case DISTRIBUTOR -> new DistributorFactory(username, password);
            case TRAVELCOMPANY -> new TravelCompanyFactory(username, password);
            default -> throw new IllegalArgumentException("Invalid role!");
        };
    }
}
