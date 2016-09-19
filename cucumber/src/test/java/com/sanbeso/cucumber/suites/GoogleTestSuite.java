package com.sanbeso.cucumber.suites;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Sample runner of cucumber features, this will run all features on the specified path
 *
 * @author Jose Beas
 * @version 1.0
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/sanbeso/cucumber/features/GoogleSearchWorkflow.feature",
        glue = {"com.sanbeso.cucumber.steps"})
public class GoogleTestSuite {

}
