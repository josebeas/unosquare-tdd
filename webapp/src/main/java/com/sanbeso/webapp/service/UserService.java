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

    /**
     * Clean session from specified username info and returns a public user
     *
     * @return public user to allow user still interact with public elements
     * @throws Exception
     */
    UserTO processLogout(String username) throws Exception;
}
