package com.oop.passenger_transport.utils;

import com.oop.passenger_transport.database.entities.User;
import lombok.Setter;

@Setter
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
