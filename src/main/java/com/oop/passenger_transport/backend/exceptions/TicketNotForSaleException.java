package com.oop.passenger_transport.backend.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class TicketNotForSaleException extends Exception {
    public TicketNotForSaleException(String s) {
          super(s);
    }
}
