package com.sanbeso.automation.divermanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;


/**
 * Abstract definition of WebDriverManager
 *
 * @author Jose Beas
 * @version 1.0
 */
public abstract class WebDriverManager {

    /**
     * {@link WebDriver} backend
     */
    private WebDriver Driver = null;

    /**
     * Whether the browser window is closed.
     */
    private boolean closed = true;

    /**
     * The browser profile.
     */
    private String profile = null;

    /**
     * Set the name of the browser profile.
     *
     * @param profile  browser profile name
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Get the name of the current browser profile.
     *
     * @return current browser profile name
     */
    public String getProfile() {
        return this.profile;
    }


    /**
     * Create a new browser window.
     */
    public abstract void newBrowser();

    /**
     * Open the specified URL in the browser.
     *
     * @param url  URL to open
     */
    public void url(String url) {
        try {
            this.Driver.navigate().to(url);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    /**
     * Close the browser window.
     */
    public void close() {
        this.Driver.close();
        this.setBrowserClosed();
    }

    /**
     * Return whether the browser window is closed.
     *
     * @return true if the browser window is close, false otherwise
     */
    public boolean isClosed() {
        return this.closed;
    }


    /**
     * Set the browser closed state to true.
     */
    public void setBrowserClosed() {
        this.closed = true;
    }

    /**
     * Set the browser closed state to false.
     */
    public void setBrowserOpened() {
        this.closed = false;
    }

    /**
     * Set the {@link WebDriver} for the browser to use.
     *
     * @param driver  the {@link WebDriver}
     */
    public void setDriver(WebDriver driver) {
        this.Driver = driver;
    }

    /**
     * Get the current {@link WebDriver}.
     *
     * @return {@link WebDriver}
     */
    public WebDriver getDriver() {
        return this.Driver;
    }

    /**
     * Find an element in the browser's DOM.
     *
     * @param by         element selection criteria
     * @param retryTime  time limit (in seconds) for retries
     *
     * @return the {@link WebElement} if found or null
     */
    public WebElement findElement(By by, int retryTime) {
        long end = System.currentTimeMillis() + retryTime * 1000;

        do {
            try {
                return this.Driver.findElement(by);
            } catch (Exception exp) {}
        } while (System.currentTimeMillis() < end);

        return null;
    }


    /**
     * Find more then one element in the browser's DOM.
     *
     * @param by         element selection criteria
     * @param retryTime  time limit (in seconds) for retries
     * @return a {@link List} of all {@link WebElement}s found
     */
    public List<WebElement> findElements(By by, int retryTime)
            throws NoSuchElementException {
        long end = System.currentTimeMillis() + retryTime * 1000;

        do {
            try {
                return this.Driver.findElements(by);
            } catch (Exception exp) {

            }
        } while (System.currentTimeMillis() < end);

        throw new NoSuchElementException("Failed to find element by " + by);
    }

}
