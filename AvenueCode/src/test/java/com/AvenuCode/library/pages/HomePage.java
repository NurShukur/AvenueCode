package com.AvenuCode.library.pages;

import com.AvenuCode.library.utilities.ConfigurationReader;
import com.AvenuCode.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    // constructor
    public HomePage()  {PageFactory.initElements(Driver.getDriver(), this); }

    // by locators
    @FindBy(xpath = "//a[contains(text(),'Sign out')]")
    public WebElement signOutButton;


    @FindBy(id = "my_task")
    public WebElement myTasksButton;


    @FindBy(xpath = "//div[text()[normalize-space()='Signed in successfully.']]")
    public WebElement SuccessfulSignMessage;
    ;

}
