package com.cfspl.nbfc.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Raghu Prasad
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com.cfspl.nbfc.features"},
        glue = {"stepdefinitions", "apphooks"},
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
)
public class SaarathiRunner {



}
