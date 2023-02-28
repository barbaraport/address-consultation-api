package com.barbaraport.addressConsultationAPI;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * this class enforces the Cucumber tests to be recognized when running
 * all the tests from the application
 *
 * @author Port, B.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/",
        glue = {"com.barbaraport.addressConsultationAPI.cucumberGlue"}
)
public class CucumberIntegrationTests {
}
