package com.oop2.passenger_transport.utils;

import com.oop2.passenger_transport.database.entities.User;
import com.oop2.passenger_transport.database.enums.Role;

public class SessionHandler {
    private static SessionHandler instance;
    private User loggedInUser;

    private SessionHandler() {
    }

    public static SessionHandler getInstance() {
        if (instance == null) {
            instance = new SessionHandler();
        }
        return instance;
    }

    public void setLoggedInUser(User user) {
            this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        if(loggedInUser!=null){
        return this.loggedInUser;}
        else {
            return null;
        }
    }

    public void logout() {
        this.loggedInUser = null;
    }
}
