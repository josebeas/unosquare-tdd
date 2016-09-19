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
@Qualifier("fireFoxDriverManager")
public class FireFoxDriverManagerImpl extends WebDriverManager {

    /**
     * Create a new browser window.
     */
    @Override
    public void newBrowser() {
        FirefoxProfile p = new FirefoxProfile();

        /*if (this.downloadDirectory != null) {
            try {
                p.setPreference("browser.download.dir", this.downloadDirectory);
            } catch (java.lang.IllegalArgumentException e) {
                System.err.println("Ill-formed downloaddir '" +
                        this.downloadDirectory + "'");
                System.exit(1);
            }
        }*/
            p.setPreference("browser.download.manager.closeWhenDone", true);
            p.setPreference("browser.download.manager.retention", 0);
            p.setPreference("browser.download.manager.showAlertOnComplete", false);
            p.setPreference("browser.download.manager.scanWhenDone", false);
            p.setPreference("browser.download.manager.skipWinSecurityPolicyChecks",
                    true);
            p.setPreference("browser.startup.page", 0);
            p.setPreference("browser.download.manager.alertOnEXEOpen", false);
            p.setPreference("browser.download.manager.focusWhenStarting", false);
            //p.setPreference("browser.download.useDownloadDir", true);


        FirefoxDriver fd = new FirefoxDriver(p);
        this.setDriver(fd);
        this.setBrowserOpened();
    }


}
