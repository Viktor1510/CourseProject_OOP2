package com.oop2.passenger_transport.backend.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
