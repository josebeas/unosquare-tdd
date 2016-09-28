package com.sanbeso.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * cucumber Step definition for Google searches
 *
 * @author Jose Beas
 * @version 1.0
 */
public class GoogleSearchSteps {

    /**
     * Selenium WebDriver local instance
     */
    WebDriver driver;

    public void setUpBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jose.beas\\.m2\\repository\\chromedriver\\chromedriver\\win32\\2.21\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^the user is on Google landing page$")
    public void user_open_Google() throws Throwable {
        setUpBrowser();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
    }

    @And("^user types ([^\\\"]*) as search term into search input box$")
    public void user_type_a_search_term(String searchTerm) throws Throwable {
        driver.findElement(By.name("q")).sendKeys(searchTerm);
    }

    @And("^user clicks on search button$")
    public void user_clicks_search_button() throws Throwable {
        driver.findElement(By.name("btnK")).click();
    }

    @Then("^user should get results related to search term$")
    public void user_should_see_results() throws Throwable {
        //Set a wait for results to load
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return !driver.findElements(By.xpath(".//div[contains(@id,'ires')]//div[contains(@class, 'g')]")).isEmpty();
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
        //after page finished loading check if results section is empty
        boolean resultsSectionIsEmpty = driver.findElements(By.xpath(".//div[contains(@id,'ires')]//div[contains(@class, 'g')]")).isEmpty();
        Assert.assertFalse(resultsSectionIsEmpty);
        //close browser if assertion matches
        driver.quit();
    }
}
