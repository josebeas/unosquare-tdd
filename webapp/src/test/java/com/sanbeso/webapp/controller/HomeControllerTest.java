package com.sanbeso.webapp.controller;

import com.sanbeso.webapp.dto.UserTO;
import com.sanbeso.webapp.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;


import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
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
    UserService userService;

    @Mock
    Random random;

    @Mock
    Model mockModel;

    @Before
    public void init(){
        classUnderTest = new HomeController();
        initMocks(this);
    }

    /**
     * Unit test for initial endpoint
     */
    @Test
    public void testShow(){
        String expectedGreeting = "Hello World!";
        String actualGreeting = classUnderTest.show();
        assertEquals("App greeting is not the expected!", expectedGreeting, actualGreeting);
    }

    /**
     * Unit test for login using public user
     */
    @Test
    public void testLogin_public_user(){
        UserTO emptyUser = new UserTO();
        UserTO actualUser = classUnderTest.login(null, null);
        assertEquals("Public user is not retrieved when null user and password", emptyUser.getFirstName(), actualUser.getFirstName());
        assertEquals("Public user is not retrieved when null user and password", emptyUser.getLastName(), actualUser.getLastName());
    }

    /**
     * Unit test for login using a valid user
     */
    @Test
    public void testLogin_valid_user(){
        UserTO expectedUser = new UserTO();
        expectedUser.setUserName("testUser");
        expectedUser.setUserName("fakeLastName");
        expectedUser.setUserName("fakeFirstName");
        //Mock user service login process
        when(userService.processLogin(any(String.class), any(String.class))).thenReturn(expectedUser);
        UserTO actualUser = classUnderTest.login("testUser", "securePassword");
        assertEquals("Public user is not retrieved when null user and password", expectedUser.getFirstName(), actualUser.getFirstName());
        assertEquals("Public user is not retrieved when null user and password", expectedUser.getLastName(), actualUser.getLastName());
        //Validate order of necessary calls
        InOrder indOrder = Mockito.inOrder(userService, random);
        indOrder.verify(userService).processLogin(any(String.class), any(String.class));
        //indOrder.verify(random).nextDouble();
        indOrder.verifyNoMoreInteractions();
    }

}
