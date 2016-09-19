package com.sanbeso.automation.divermanager.impl;

import com.sanbeso.automation.divermanager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Chrome Selenium WebDriver manager implementation
 *
 * @author Jose Beas
 * @version 1.0
 */
@Component
@Qualifier("chromeDriverManager")
public class ChromeDriverManagerImpl extends WebDriverManager {

    /**
     * Create a new browser window.
     */
    @Override
    public void newBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jose.beas\\.m2\\repository\\chromedriver\\chromedriver\\win32\\2.21\\chromedriver.exe" );
        WebDriver cd =new ChromeDriver();
        this.setDriver(cd);
        this.setBrowserOpened();
    }


}
