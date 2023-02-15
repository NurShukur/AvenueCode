package com.AvenuCode.library.stepdefinitions;
import com.AvenuCode.library.pages.HomePage;
import com.AvenuCode.library.pages.MyTasksPage;

import com.AvenuCode.library.utilities.BrowserUtils;
import com.AvenuCode.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;



public class MyTasksStepDef {


    MyTasksPage myTasksPage= new MyTasksPage();
    HomePage homePage=new HomePage();

    @Given("the user is on the task management page")
    public void theUserIsOnTheTaskManagementPage() {
        homePage.myTasksButton.click();
        Assert.assertTrue(myTasksPage.todoListHeading.isDisplayed());
    }

    @When("the user enters a task name {string} with more than three characters")
    public void theUserEntersATaskNameWithMoreThanThreeCharacter(String name) {
        myTasksPage.new_task_input.sendKeys(name);

    }

    @And("clicks on the add button of the task")
    public void clicksOnTheButton() {
        myTasksPage.new_task_plus_button.click();
    }


    @Then("the newly added task should be displayed on the task list")
    public void theNewlyAddedTaskShouldBeDisplayedOnTheTaskList() {
        Assert.assertTrue(myTasksPage.taskBody.isDisplayed());
    }

    @When("the user enters a task name {string} with less than three characters")
    public void theUserEntersATaskNameWithLessThanThreeCharacters(String name) {

        myTasksPage.new_task_input.sendKeys(name);

    }

    @Then("the newly added task should not be displayed on the task list")
    public void theNewlyAddedTaskShouldNotBeDisplayedOnTheTaskList() {


    }

    @And("removes added tasks")
    public void removesAddedTasks() throws InterruptedException {


        Thread.sleep(2000); // added wait  for demo purposes , not neccessary for automation
        if (myTasksPage.removeButton.isDisplayed()) {
            BrowserUtils.waitForVisibility(myTasksPage.removeButton, 5).click();
        }
    }

    @When("clicks on save button")
    public void clicksOnSaveButton() {

        myTasksPage.saveButton.click();

    }

    @And("press Enter keys on  description input area")
    public void pressEnterKeysOnDescriptionInputArea() {

        myTasksPage.new_task_input.sendKeys(Keys.ENTER);

    }

    @And("User minimize browser screen to <{int}> px")
    public void userMinimizeBrowserScreenToPx(int width) {
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("window.innerWidth = arguments[0];", width);
        Dimension size = new Dimension(width, 600);
        Driver.getDriver().manage().window().setSize(size);
    }

    @Then("my task button should be visible")
    public void myTaskButtonShouldBeVisible() {

        Assert.assertTrue(homePage.myTasksButton.isDisplayed());
    }

    @When("click mytask button")
    public void clickMytaskButton() {

        BrowserUtils.waitForVisibility(homePage.myTasksButton,5).click();
    }

    @Then("Verify user on mytask page")
    public void verifyUserOnMytaskPage() {

        Assert.assertTrue(myTasksPage.new_task_input.isDisplayed());

    }


}
