package com.oop.passenger_transport.backend;

import org.mindrot.jbcrypt.BCrypt;
import com.oop.passenger_transport.backend.exceptions.UserNotFoundException;
import com.oop.passenger_transport.database.entities.User;
import com.oop.passenger_transport.database.repositories.UserRepository;
import com.oop.passenger_transport.utils.SessionHandler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    /**
     * Attempts to authenticate a user with the given credentials.
     *
     * @param username the input username
     * @param password the input password (plain text)
     * @return the authenticated User
     * @throws IllegalArgumentException if input is missing or invalid
     * @throws SecurityException        if user not found or credentials invalid
     */
    public User logIn(String username, String password) throws UserNotFoundException {
        validateInput(username, password);

        Optional<User> userOpt = Optional.ofNullable(userRepository.findByUsername(username.trim()));

        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(password)) {
            logger.warn("Wrong username or password");
            throw new SecurityException("Wrong username or password!.");
        }


        User user = userOpt.get();

        String storedPassword = user.getPassword();


        if (isPasswordMatch(user.getPassword(), storedPassword)) {
            SessionHandler.getInstance().setLoggedInUser(user);
            logger.info("User retrieved successfully: {}", user.getUsername());
            return user;
        } else {
            logger.error("Invalid password for user: {}", username);
            throw new UserNotFoundException("Invalid password");
        }
    }

    private void validateInput(String username, String password) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is blank.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is blank.");
        }

    }

    private boolean isPasswordMatch(String providedPassword, String storedPassword) {
        if (storedPassword.startsWith("$2a$") || storedPassword.startsWith("$2b$")) {
            return BCrypt.checkpw(providedPassword, storedPassword);
        } else {
            return providedPassword.equals(storedPassword);
        }
    }
}

