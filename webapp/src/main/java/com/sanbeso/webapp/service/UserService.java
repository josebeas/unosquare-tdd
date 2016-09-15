package com.sanbeso.webapp.service;

import com.sanbeso.webapp.dto.UserTO;

/**
 * User service Interface
 *
 * @author Jose Beas
 * @version 1.0
 */
public interface UserService {

    /**
     * Login process
     *
     * @param username string with username to log in
     * @param password string with login password
     * @return User object to store in session
     */
    UserTO processLogin(String username, String password);

}
