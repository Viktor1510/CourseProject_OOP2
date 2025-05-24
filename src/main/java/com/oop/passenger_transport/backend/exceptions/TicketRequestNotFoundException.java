package com.oop.passenger_transport.backend.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class TicketRequestNotFoundException extends Exception{
    public TicketRequestNotFoundException(String message) {
        super(message);
    }
}
