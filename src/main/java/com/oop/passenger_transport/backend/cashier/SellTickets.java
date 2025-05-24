package com.oop.passenger_transport.backend.cashier;

import com.oop.passenger_transport.database.repositories.TicketFormRepository;
import com.oop.passenger_transport.database.repositories.TicketRepository;
import com.oop.passenger_transport.database.repositories.UserProfileRepository;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
public class SellTickets {
    private final TicketRepository ticketRepository;

    private final TicketFormRepository ticketFormRepository;

    private final UserProfileRepository userProfileRepository;
    public void sellTickets(String EGN, List<Long> ticketIds,
                            LocalDateTime boughtAtDate, LocalTime boughtAtTime){

    }
}
