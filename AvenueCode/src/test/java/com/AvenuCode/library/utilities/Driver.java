package com.AvenuCode.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver  {


    public static final String USERNAME ="NurShukur";
    public static final String ACCESS_KEY ="53d1a523-9fd0-4109-8a32-f341a14a6da5";
    public static final String URL ="https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    private Driver() { }

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    public static WebDriver getDriver()  {
        if (driverPool.get() == null) {
            String browser = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");


            DesiredCapabilities caps=new DesiredCapabilities();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows 10"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;

                case "safari":

                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;

                case "remote-chrome":

                    caps.setBrowserName(browser);
                    caps.setCapability("platform","Windows 10");
                    caps.setCapability("browserName","chrome");
                    caps.setCapability("version","latest");
                    caps.setCapability("name", "Apollo Smoke tests");

                    try {

                        driverPool.set(new RemoteWebDriver(new URL(URL),caps ));
                    }

                    catch (MalformedURLException e) {

                        e.printStackTrace();
                    }

                    break;



//

                case "remote-iphone":


                 //   caps.setCapability("appiumVersion", "1.20.1");

                    caps.setCapability("appiumVersion", "1.20.1");
                    caps.setCapability("deviceName","iPhone 11 Simulator");
                    caps.setCapability("deviceOrientation", "portrait");
                    caps.setCapability("platformVersion","14.3");
                    caps.setCapability("platformName", "iOS");
                    caps.setCapability("browserName", "Safari");


                    try {

                        driverPool.set(new RemoteWebDriver(new URL(URL),caps ));
                    }

                    catch (MalformedURLException e) {

                        e.printStackTrace();
                    }

            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

