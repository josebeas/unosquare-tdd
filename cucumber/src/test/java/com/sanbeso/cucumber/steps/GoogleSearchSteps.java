package com.sanbeso.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 17/09/16.
 */
public class GoogleSearchSteps {

    WebDriver driver = new FirefoxDriver();

    @Given("^the user is on Google landing page$")
    public void setup() throws Throwable {
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
    }

    @And("^user types ([^\\\"]*) as search term into search input box$")
    public void she_signs_up() throws Throwable {
        driver.findElement(By.name("q")).click();
    }

    @And("^user clicks on search button$")
    public void user_clicks_search_button() throws Throwable {
        driver.findElement(By.name("btnK")).click();
    }

    @Then("^user should get results related to search term$")
    public void she_should_be_logged_in_to_the_application() throws Throwable {
        boolean signOutLinkDisplayed = driver.findElement(By.className("g")).isDisplayed();
        Assert.assertTrue(signOutLinkDisplayed);
    }
}
