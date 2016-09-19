package com.sanbeso.automation.divermanager.impl;

import com.sanbeso.automation.divermanager.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Firefox Selenium WebDriver manager implementation
 *
 * @author Jose Beas
 * @version 1.0
 */
@Component
@Qualifier("firefoxDriverManager")
public class FireFoxDriverManagerImpl extends WebDriverManager {

    /**
     * Create a new browser window.
     */
    @Override
    public void setUpBrowser() {
        FirefoxProfile p = new FirefoxProfile();
        p.setPreference("browser.download.manager.closeWhenDone", true);
        p.setPreference("browser.download.manager.retention", 0);
        p.setPreference("browser.download.manager.showAlertOnComplete", false);
        p.setPreference("browser.download.manager.scanWhenDone", false);
        p.setPreference("browser.download.manager.skipWinSecurityPolicyChecks", true);
        p.setPreference("browser.startup.page", 0);
        p.setPreference("browser.download.manager.alertOnEXEOpen", false);
        p.setPreference("browser.download.manager.focusWhenStarting", false);
        FirefoxDriver fd = new FirefoxDriver(p);
        this.setDriver(fd);
        this.setBrowserOpened();
    }


}
