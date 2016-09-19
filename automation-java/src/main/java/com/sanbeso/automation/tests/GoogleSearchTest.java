package com.sanbeso.automation.tests;

import com.sanbeso.automation.configuration.SpringConfiguration;
import com.sanbeso.automation.divermanager.impl.ChromeDriverManagerImpl;
import com.sanbeso.automation.divermanager.impl.FireFoxDriverManagerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by user on 10/09/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class GoogleSearchTest {

    @Autowired
    @Qualifier("chromeDriverManager")
    ChromeDriverManagerImpl driverManager;

    @Test
    public void testMain(){
        driverManager.newBrowser();
        driverManager.getDriver().get("http://www.google.com");

    }

}
