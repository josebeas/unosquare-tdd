package com.sanbeso.cucumber.steps;

import com.sanbeso.webapp.dto.UserTO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Sample WebApp steps definition
 *
 * @author Jose Beas
 * @version 1.0
 */
public class WebAppSteps {

    private UserTO user;

    private UserTO publicUser;


    @Given("^a user with no username and password$")
    public void loadUserInfo() throws Throwable {
        UserTO user = new UserTO();
        user.setUserName(null);
        user.setLastName(null);
        user.setFirstName(null);
        this.user = user;
    }

    @Given("^a user already logged$")
    public void setSignedUser() throws Throwable {
        UserTO user = new UserTO();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setUserName("username");
        this.user = user;
    }

    @When("^user hits login endpoint with null user and null password$")
    public UserTO hitLoginEndpoint() throws Throwable {
        RestTemplate restTemplate = new RestTemplate();
        publicUser = restTemplate.getForObject("http://localhost:8080/webapp/login", UserTO.class);
        return publicUser;
    }

    @When("^user hits login logout with null user and null password$")
    public UserTO hitLogoutEndpoint() throws Throwable {
        RestTemplate restTemplate = new RestTemplate();
        publicUser = restTemplate.getForObject("http://localhost:8080/webapp/logout?username=username", UserTO.class);
        return publicUser;
    }

    @Then("a public user should be returned to allow public navigation")
    public void verifyPublicUser(){
        assertTrue("No public user found, please verify login parameters", publicUser.isPublic() );
        assertEquals("No public user found, please verify login parameters", publicUser.getUserName(), user.getUserName() );
    }

}
