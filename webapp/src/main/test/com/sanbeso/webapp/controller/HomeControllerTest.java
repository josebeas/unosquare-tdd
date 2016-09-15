package com.sanbeso.webapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;


import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by jose.beas on 9/14/2016.
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

}
