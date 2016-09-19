package com.sanbeso.webapp.controller;

import com.sanbeso.webapp.dto.UserTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;


import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Unit tests for Home Spring controller
 *
 * @author Jose Beas
 * @version 1.0
 */
public class HomeControllerTest {

    @InjectMocks
    HomeController classUnderTest;

    @Mock
    Model mockModel;

    @Before
    public void init(){
        classUnderTest = new HomeController();
        initMocks(this);
    }

    @Test
    public void testShow(){
        String expectedGreeting = "Hello World!";
        String actualGreeting = classUnderTest.show();
        assertEquals("App greeting is not the expected!", expectedGreeting, actualGreeting);
    }

    @Test
    public void testLogin(){
        UserTO emptyUser = new UserTO();
        UserTO actualUser = classUnderTest.login(null, null);
        assertEquals("Public user is not retrieved when null user and password", emptyUser.getFirstName(), actualUser.getFirstName());
        assertEquals("Public user is not retrieved when null user and password", emptyUser.getLastName(), actualUser.getLastName());
    }

}
