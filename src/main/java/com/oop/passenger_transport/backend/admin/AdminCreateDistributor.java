package com.oop.passenger_transport.backend.admin;

import com.oop.passenger_transport.backend.exceptions.IncorrectInputException;
import com.oop.passenger_transport.backend.exceptions.UserExistsException;
import com.oop.passenger_transport.database.enums.Role;
import com.oop.passenger_transport.database.repositories.UserRepository;
import com.oop.passenger_transport.database.entities.User;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;


@AllArgsConstructor
public class AdminCreateDistributor {
    private final UserRepository userRepository;
    private final static Logger logger = LoggerFactory.getLogger(AdminCreateTravelCompany.class);

    public void createDistributor(String username, String password, String repeatedPassword, Double honorarium)
            throws UserExistsException, IncorrectInputException {

        if(userRepository.findByUsername(username)!=null){
            logger.error("User found!");
            throw new UserExistsException("User already exists!");

        }

        checkDistributorFieldsInput(username,password,repeatedPassword);

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        User user = User.builder()
                .username(username)
                .password(hashedPassword)
                .honorarium(honorarium)
                .role(Role.DISTRIBUTOR)
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
        System.out.println("The distributor: " + user.getUsername() + "created successfully!" );
    }

    private void checkDistributorFieldsInput(String username, String password, String repeatPassword)
            throws IncorrectInputException {
        if (username == null || password == null || repeatPassword == null || username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            logger.error("Please fill out all fields!");
            throw new IncorrectInputException("Please fill out all fields!");
        }

        if (!password.equals(repeatPassword)) {
            logger.error("The passwords did not match!");
            throw new IncorrectInputException("The passwords did not match!");
        }
    }
    }
