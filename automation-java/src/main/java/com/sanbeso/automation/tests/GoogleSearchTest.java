package com.sanbeso.automation.tests;

import com.sanbeso.automation.configuration.SpringConfiguration;
import com.sanbeso.automation.divermanager.impl.ChromeDriverManagerImpl;
import com.sanbeso.automation.divermanager.impl.FireFoxDriverManagerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Automated test for Google page using selenium chrome driver
 *
 * @author Jose Beas
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class GoogleSearchTest {

    /**
     * Web driver manager used to handle web driver instances
     */
    @Autowired
    @Qualifier("chromeDriverManager")
    ChromeDriverManagerImpl driverManager;

    /**
     * Automated test for Google main search page
     */
    @Test
    public void testMain(){
        driverManager.url("http://www.google.com");
        String actualPageTitle = driverManager.getPageTitle();
        assertEquals("Page title does not match, are you on google.com?", "Google", actualPageTitle);
        By searchInput = By.name("q");
        boolean isSearchInputVisible = driverManager.isVisible(searchInput);
        assertTrue("No search input available, did ui changed", isSearchInputVisible);
        driverManager.type(searchInput, "Unosquare");
        boolean isSearchResultsVisible = driverManager.isVisible( By.xpath(".//div[contains(@id,'ires')]//div[contains(@class, 'g')]"));
        assertTrue("No results found, is this possible?", isSearchResultsVisible);
        driverManager.close();
    }

}
