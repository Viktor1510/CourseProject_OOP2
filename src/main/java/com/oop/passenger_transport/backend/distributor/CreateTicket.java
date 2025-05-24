package com.oop.passenger_transport.backend.distributor;

import com.oop.passenger_transport.backend.exceptions.TicketNotForSaleException;
import com.oop.passenger_transport.database.repositories.TicketRepository;
import com.oop.passenger_transport.database.repositories.TicketRequestRepository;
import com.oop.passenger_transport.backend.exceptions.TicketRequestNotFoundException;
import com.oop.passenger_transport.database.entities.Ticket;
import com.oop.passenger_transport.database.entities.TicketRequest;
import com.oop.passenger_transport.database.enums.RequestStatus;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
public class CreateTicket {
    private final TicketRepository ticketRepository;

    private final TicketRequestRepository ticketRequestRepository;

    private static final Logger logger = LoggerFactory.getLogger(CreateTicket.class);
    public void createTicket( LocalDateTime departure,
                             LocalDateTime arrival, Long ticketRequestId,
                             String seatNumber, LocalDateTime saleDate, LocalTime hourArrival,
                              Integer saleCount)
            throws TicketRequestNotFoundException, TicketNotForSaleException {

        TicketRequest ticketRequest=ticketRequestRepository.findById(ticketRequestId);
        if(ticketRequest.getId()==null){
            logger.error("Ticket request not found!");
            throw  new TicketRequestNotFoundException("Ticket request not found!");
        }


        if (ticketRequest.getStatus()== RequestStatus.APPROVED){

            validateFields(departure, arrival, seatNumber, saleDate, hourArrival, saleCount);
            Ticket ticket=Ticket.builder().trip(ticketRequest.getTrip())
                    .saleDate(LocalDateTime.now())
                    .seatNumber(seatNumber)
                    .hourArrival(hourArrival)
                    .saleDate(saleDate)
                    .departure(departure)
                    .arrival(arrival)
                    .saleCount(saleCount)
                    .build();
            ticketRepository.save(ticket);
            logger.info("Ticket saved successfully!");
        }
        else{
            logger.error("Ticket is canceled and cannot be sold!");
            throw new TicketNotForSaleException("Ticket is canceled and cannot be sold!");
        }

    }

    private void validateFields(LocalDateTime departure, LocalDateTime arrival,
                                String seatNumber, LocalDateTime saleDate, LocalTime hourArrival,
                                Integer saleCount) {
        StringBuilder errors = new StringBuilder();

        if (departure == null) errors.append("Departure time is required. ");
        if (arrival == null) errors.append("Arrival time is required. ");
        if (saleDate == null) errors.append("Sale date is required. ");
        if (hourArrival == null) errors.append("Hour of arrival is required. ");
        if (seatNumber == null || seatNumber.trim().isEmpty()) errors.append("Seat number is required. ");
        if (saleCount == null || saleCount <= 0) errors.append("Sale count must be a positive number. ");

        if (!errors.isEmpty()) {
            logger.warn("Invalid input for ticket creation: {}", errors.toString().trim());
            throw new IllegalArgumentException("Invalid input: " + errors.toString().trim());
        }
    }

}
