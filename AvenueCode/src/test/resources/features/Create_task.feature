Feature: Task Management in ToDo App

  Background: : Login with valid credentials
    Given user is on login page
    And user clicks on  sign in button
    When user enters username  and password as from properties file
    Then the user should be redirected to the Home Page

@all
  #The user should be able to enter a new task by hitting enter or clicking on the add task button.

  Scenario: Create a Task using click button

    Given the user is on the task management page
    When the user enters a task name "title" with more than three characters
    And clicks on the add button of the task
    Then the newly added task should be displayed on the task list
    And removes added tasks




        # Clicking this link will redirect the user to a page with all the created tasks so far
  @all
  Scenario: Verify  Mytask link redirect to task page

    Given the user is on the task management page
    Then  my task button should be visible
    When  click mytask button
    Then Verify user on mytask page


  @all

    #The task should require at least three characters so the user can enter it.
  Scenario: Verify task name should not accept less than 3 characters

    Given the user is on the task management page
    When the user enters a task name "ab" with less than three characters
    And clicks on the add button of the task
    Then the newly added task should not be displayed on the task list
    Then  removes added tasks



  #The user should be able to enter a new task by hitting enter or clicking on the add task button.

  Scenario: Create a Task by using Enter key

    Given the user is on the task management page
    When the user enters a task name "title_with_Enter" with more than three characters
    And press Enter keys on  description input area
    Then the newly added task should be displayed on the task list
    And removes added tasks


    #The user should always see the ‘My Tasks’ link on the NavBar
  @all
  Scenario: Verify ‘My Tasks’ link on the NavBar should be visible on smaller screen

    Given the user is on the task management page
    Then  my task button should be visible
    When User minimize browser screen to <300> px
    Then  my task button should be visible





