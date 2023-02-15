package com.AvenuCode.library.stepdefinitions;

import com.AvenuCode.library.pages.HomePage;
import com.AvenuCode.library.pages.LoginPage;
import com.AvenuCode.library.utilities.BrowserUtils;
import com.AvenuCode.library.utilities.ConfigurationReader;
import com.AvenuCode.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginPageStepDef {


    LoginPage loginPage = new LoginPage();
    HomePage homePage= new HomePage();


    @Given("user is on login page")
    public void userIsOnLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters username  and password as from properties file")
    public void userEntersUsernameAndPasswordAsFromPropertiesFile() {
        loginPage.enterUnAndPswdFromProperties();
    }

    @And("user clicks on  sign in button")
    public void userClicksOnSignInButton() {
        loginPage.signInButton.click();
    }

    @And("the user should be redirected to the Home Page")
    public void theUserShouldBeRedirectedToTheHomePage() {
        Assert.assertTrue(homePage.signOutButton.isDisplayed());
        Assert.assertTrue(homePage.SuccessfulSignMessage.isDisplayed());

    }


}
