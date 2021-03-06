package com.sanbeso.webapp.controller;

import com.mangofactory.swagger.annotations.ApiModel;
import com.sanbeso.webapp.dto.UserTO;
import com.sanbeso.webapp.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


/**
 * Demo Login Controller for Sanbeso Web Application
 *
 * @author Jose Beas
 * @version 1.0
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "", description = "Home and login sample controller")
public class HomeController {

    private static final Log LOGGER = LogFactory.getLog(HomeController.class);

    @Autowired
    UserService userService;

    Random randomGenerator;

    /**
     * Shows initial greeting from base web application.
     *
     * @return hello world message.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show() {
        LOGGER.info("requested a greeting");
        return "Hello World!";
    }

    /**
     * Look for user on database and validate input password if it match then return signed user
     *
     * @param username username input to log in
     * @param password password input
     * @return signed user
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation(value = "Provides a valid user")
    @ApiModel(type = UserTO.class)
    public UserTO login(@RequestParam(required = false) String username,
                          @RequestParam(required = false) String password){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            LOGGER.info("requested a public login");
            return new UserTO();
        }
        return userService.processLogin(username, password);
    }

    /**
     *
     * @param username
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ApiOperation(value = "Provides a valid user")
    @ApiModel(type = UserTO.class)
    public UserTO logout(@RequestParam(required = false) String username) throws Exception {
        if(StringUtils.isEmpty(username)){
            LOGGER.info("returning a public login");
            return new UserTO();
        }
        return userService.processLogout(username);
    }

}
