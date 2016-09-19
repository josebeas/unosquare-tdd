package com.sanbeso.automation.tests;

import com.sanbeso.automation.configuration.SpringConfiguration;
import com.sanbeso.automation.divermanager.impl.ChromeDriverManagerImpl;
import com.sanbeso.automation.divermanager.impl.FireFoxDriverManagerImpl;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Abstract TestBase, sets class with all necessary stuff to run automated tests
 *
 * @author Jose Beas
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public abstract class TestBase {

    /**
     * Web driver manager to load pages and interact with them
     */
    @Autowired
    @Qualifier("chromeDriverManager")
    private ChromeDriverManagerImpl webDriver;

    public WebDriver initTest(String url){
        WebDriver driver = webDriver.getDriver();
        driver.get(url);
        return driver;
    }



}
