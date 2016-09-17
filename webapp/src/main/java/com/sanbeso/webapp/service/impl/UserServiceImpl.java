package com.sanbeso.webapp.service.impl;

import com.sanbeso.webapp.dto.UserTO;
import com.sanbeso.webapp.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Implementation of user service interface, helps on login and user related process
 *
 * @author Jose Beas
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Log LOGGER = LogFactory.getLog(UserServiceImpl.class);

    /**
     * Stub login process
     *
     * @param username string with username to log in
     * @param password string with login password
     * @return User object to store in session
     */
    public UserTO processLogin(String username, String password) {
        UserTO user = new UserTO();
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setPublic(false);
        user.setUserName(username);
        LOGGER.info("logged as " + user.getUserName());
        return user;
    }
}
