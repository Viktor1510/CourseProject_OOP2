package com.oop2.passenger_transport.database.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RequestStatus {
    PENDING("Pending"),

    APPROVED("Approved"),

    REJECTED("Rejected");
    private final String status;
}
