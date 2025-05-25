package com.oop.passenger_transport.backend.travel_company;

import com.oop.passenger_transport.utils.SessionHandler;
import com.oop.passenger_transport.database.entities.TravelTrip;
import com.oop.passenger_transport.database.entities.User;
import com.oop.passenger_transport.database.repositories.TravelTripRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@AllArgsConstructor
public class CreateTravelTrip {

    private final TravelTripRepository tripRepository;
    private static final Logger logger = LoggerFactory.getLogger(CreateTravelTrip.class);


    public TravelTrip createTravelTrip(
            String destination,
            int seatCount,
            String transportType,
            int ticketLimit
    ) throws IllegalArgumentException {

         User organizer = SessionHandler.getInstance().getLoggedInUser();
        validateTripData(destination, seatCount, transportType, ticketLimit);
        TravelTrip trip = TravelTrip.builder()
                .organizer(organizer)
                .destination(destination.trim())
                .seatCount(seatCount)
                .transportType(transportType.trim())
                .ticketLimit(ticketLimit)
                .createdAt(LocalDateTime.now())
                .build();

        tripRepository.save(trip);
        logger.info("The travel trip is successfully created to {}", destination);
        return trip;
    }

    private void validateTripData(
            String destination,

            int seatCount,
            String transportType,
            int ticketLimit
    ) {
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination must not be empty");
        }

        if (seatCount < 10) {
            throw new IllegalArgumentException("The seats have to be a positive number above 10");
        }

        if (ticketLimit <= 0) {
            throw new IllegalArgumentException("Ticket limit must be positive number");
        }

        if (transportType == null || transportType.trim().isEmpty()) {
            throw new IllegalArgumentException("Type of transport should not be empty.");
        }
    }
}