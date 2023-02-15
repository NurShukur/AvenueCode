package com.AvenuCode.library.pages;

import com.AvenuCode.library.utilities.ConfigurationReader;
import com.AvenuCode.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // constructor
    public LoginPage()  {PageFactory.initElements(Driver.getDriver(), this); }

    // by locators
    @FindBy(id = "sign_in")
    public WebElement signInButton;

    @FindBy(id= "user_email")
    public WebElement user_email;

    @FindBy(id="user_password")
    public WebElement password;

    @FindBy(name="commit")
    public WebElement loginButton;



    public void enterUnAndPswdFromProperties(){
        loginButton.click();
        this.user_email.sendKeys(ConfigurationReader.getProperty("username"));
        this.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();

    }

    public void loggedin ()  {

        loginButton.click();
    }

}
