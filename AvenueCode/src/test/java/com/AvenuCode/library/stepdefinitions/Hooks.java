package com.AvenuCode.library.stepdefinitions;

import com.AvenuCode.library.utilities.ConfigurationReader;
import com.AvenuCode.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().window().maximize();
        System.out.println("Running on ..." + ConfigurationReader.getProperty("browser"));
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        scenario.write("Complete scenario: "+ scenario.getName());
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());
        }

        Thread.sleep(3000);
        Driver.closeDriver();
    }
    }

