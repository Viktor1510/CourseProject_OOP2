package com.oop.passenger_transport.backend.travel_company;

import com.oop.passenger_transport.database.entities.TicketRequest;
import com.oop.passenger_transport.database.entities.User;
import com.oop.passenger_transport.database.repositories.TicketRepository;
import com.oop.passenger_transport.database.repositories.TicketRequestRepository;
import com.oop.passenger_transport.utils.SessionHandler;
import com.oop.passenger_transport.database.enums.RequestStatus;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@AllArgsConstructor
public class ApproveTickerRequest {
    private static final Logger logger = LoggerFactory.getLogger(ApproveTickerRequest.class);
    private final TicketRequestRepository ticketRequestRepository = new TicketRequestRepository();

    private final TicketRepository ticketRepository;

    public void respondToRequest(Long requestId, boolean approve) {
        try {
            User travelCompanyUser = SessionHandler.getInstance().getLoggedInUser();

            TicketRequest request = ticketRequestRepository.findById(requestId);
            if (request == null) {
                throw new IllegalArgumentException("Ticket request with ID " + requestId + " does not exist.");
            }

            if (!request.getTrip().getOrganizer().getId().equals(travelCompanyUser.getId())) {
                throw new SecurityException("You are not authorized to respond to this ticket request.");
            }

            if (request.getStatus() != RequestStatus.PENDING) {
                throw new IllegalStateException("This ticket request has already been processed.");
            }

            RequestStatus newStatus = approve ? RequestStatus.APPROVED : RequestStatus.REJECTED;
            request.setStatus(newStatus);
            ticketRequestRepository.update(request);


            logger.info("Travel company '{}' {} ticket request with ID {}.",
                    travelCompanyUser.getUsername(),
                    approve ? "approved" : "rejected",
                    requestId);

        } catch (IllegalArgumentException | IllegalStateException | SecurityException e) {
            logger.warn("Ticket request processing issue: {}", e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error while processing ticket request with ID {}.", requestId, e);
            throw new RuntimeException("Failed to process the ticket request. Please try again later.", e);
        }



    }

}
