package com.AvenuCode.library.pages;

import com.AvenuCode.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTasksPage {

    // constructor
    public MyTasksPage()  {PageFactory.initElements(Driver.getDriver(), this); }

    // by locators
    @FindBy(tagName = "h1")
    public WebElement todoListHeading;

    @FindBy(id = "new_task")
    public WebElement new_task_input;

    @FindBy(xpath = "//div[@class='input-group']//span[1]")
    public WebElement new_task_plus_button;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement task_checkBox;

    @FindBy(xpath = "//a[@editable-text='task.body']")
    public WebElement taskBody;

    @FindBy(xpath = "//button[contains(.,'Manage Subtasks')]")
    public WebElement manageSubtasksButton;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    public WebElement closeButton;

}
