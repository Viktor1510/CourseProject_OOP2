package com.oop.passenger_transport.backend.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class IncorrectInputException extends Exception {
    public IncorrectInputException(String message) {
        super(message);
    }
}
