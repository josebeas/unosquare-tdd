package com.sanbeso.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by jose.beas on 9/19/2016.
 */
public class GoogleSearchTestImpl extends TestBase {

    WebDriver webDriver;

    @Test
    public void testRun(){
        webDriver = initTest("http://www.google.com");
    }
}
