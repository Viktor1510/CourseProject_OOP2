package com.oop.passenger_transport.backend.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class UserExistsException extends Exception {
    public UserExistsException(String message) {
        super(message);
    }
}