package com.example.courseproject_oop2;

public class UserFactory {
    public UserAbstractFactory createUser(String username, String password,Role role)
    {
        UserAbstractFactory userAbstractFactory;
        switch (role){
            case ADMIN :
                userAbstractFactory=new AdminFactory(username,password);
                break;
            case CASHIER:
                userAbstractFactory= new CashierFactory(username,password);
                break;
            case DISTRIBUTOR:
                userAbstractFactory= new DistributorFactory(username,password);
                break;
            case TRAVELCOMPANY:
                userAbstractFactory= new TravelCompanyFactory(username,password);
                break;
            default:
               throw new IllegalArgumentException("Invalid role!");
        }
        return userAbstractFactory;
    }
}
