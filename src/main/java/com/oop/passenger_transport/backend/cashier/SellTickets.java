package com.oop.passenger_transport.backend.cashier;

import com.oop.passenger_transport.database.entities.*;
import com.oop.passenger_transport.database.repositories.*;
import com.oop.passenger_transport.utils.SessionHandler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SellTickets {
    private final TicketRepository ticketRepository;
    private final TicketFormRepository ticketFormRepository;
    private final UserProfileRepository userProfileRepository;

    private static final Logger logger = LoggerFactory.getLogger(SellTickets.class);

    public void sellTickets(String EGN, List<Long> ticketIds,
                            LocalDateTime boughtAtDate, LocalTime boughtAtTime) {

        try {
            User cashier = SessionHandler.getInstance().getLoggedInUser();
            if (cashier == null) {
                throw new SecurityException("No logged in cashier.");
            }

            UserProfile userProfile = userProfileRepository.findByEGN(EGN);
            if (userProfile == null) {
                throw new IllegalArgumentException("No user profile found with EGN: " + EGN);
            }

            List<Ticket> tickets = new ArrayList<>();
            for (Long ticketId : ticketIds) {
                Ticket ticket = ticketRepository.findById(ticketId);
                if (ticket == null) {
                    throw new IllegalArgumentException("Ticket with ID " + ticketId + " does not exist.");
                }
                tickets.add(ticket);
            }

        TicketForm ticketForm = TicketForm.builder()
                    .cashier(cashier)
                    .userProfile(userProfile)
                    .tickets(tickets)
                    .boughtAtDate(boughtAtDate)
                    .boughtAtTime(boughtAtTime)
                    .build();

            ticketFormRepository.save(ticketForm);

            logger.info("Tickets successfully sold to user with EGN: {}", EGN);
        } catch (Exception e) {
            logger.error("Failed to sell tickets: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to sell tickets. Please try again.", e);
        }
    }
}
