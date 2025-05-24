package com.oop.passenger_transport.backend.admin;


import com.oop.passenger_transport.backend.exceptions.IncorrectInputException;
import com.oop.passenger_transport.backend.exceptions.UserExistsException;
import com.oop.passenger_transport.database.entities.User;
import com.oop.passenger_transport.database.enums.Role;
import com.oop.passenger_transport.database.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mindrot.jbcrypt.BCrypt;

@AllArgsConstructor
public class AdminCreateTravelCompany {
    private final UserRepository userRepository;
    private final static Logger logger = LoggerFactory.getLogger(AdminCreateTravelCompany.class);

    public void createTravelCompany(String username, String password, String repeatedPassword, double honorarium)
            throws UserExistsException, IncorrectInputException {

          if(userRepository.findByUsername(username)!=null){
              logger.error("Username found!");
               throw new UserExistsException("User already exists!");

           }

          checkTravelCompanyFieldsInput(username,password,repeatedPassword);

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        User user = User.builder()
                .username(username)
                .password(hashedPassword)
                .honorarium(honorarium)
                .role(Role.TRAVELCOMPANY)
                .build();

        userRepository.save(user);
        System.out.println("The travel company: " + user.getUsername() + "created successfully!" );
    }

    private void checkTravelCompanyFieldsInput(String username, String password, String repeatPassword)
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
