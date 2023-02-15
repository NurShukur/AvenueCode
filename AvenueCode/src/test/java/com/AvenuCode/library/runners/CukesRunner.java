package com.AvenuCode.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/features"},
        glue = {"com/AvenuCode/library/stepdefinitions"},
        plugin = {"html:target/report/default-cucumber-reports",
                "json:target/cucumber/report.json",
                "junit:target/report.xml",
                "pretty"},
        tags = "@all",
        monochrome = true,
        dryRun = false

)

public class CukesRunner {
}
