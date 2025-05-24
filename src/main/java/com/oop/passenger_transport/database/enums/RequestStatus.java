package com.oop.passenger_transport.database.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum RequestStatus {
    PENDING("Pending"),

    APPROVED("Approved"),

    REJECTED("Rejected");
    private final String status;

    RequestStatus(String status) {
        this.status = status;
    }
}
