package com.oop.passenger_transport.backend.distributor;

import com.oop.passenger_transport.database.repositories.TicketRequestRepository;
import com.oop.passenger_transport.utils.SessionHandler;
import com.oop.passenger_transport.database.entities.TicketRequest;
import com.oop.passenger_transport.database.entities.TravelTrip;
import com.oop.passenger_transport.database.entities.User;
import com.oop.passenger_transport.database.enums.RequestStatus;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@AllArgsConstructor
public class CreateTicketRequest {

    private static final Logger logger = LoggerFactory.getLogger(CreateTicketRequest.class);
    private final TicketRequestRepository ticketRequestRepository;

    public void submitRequest(User distributor, TravelTrip trip) {
        try {
            User user= SessionHandler.getInstance().getLoggedInUser();
            TicketRequest request = TicketRequest.builder()
                    .distributor(user)
                    .trip(trip)
                    .status(RequestStatus.PENDING)
                    .build();

            ticketRequestRepository.save(request);

            logger.info("Distributor '{}' made successfully request for tickets for trip to {}.",
                    distributor.getUsername(), trip.getDestination());

        } catch (IllegalArgumentException e) {
            logger.warn("Invalid request: {}", e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("Error with creating a record in DB.", e);
            throw new RuntimeException("Cannot send request to DB.", e);
        }
    }
}

