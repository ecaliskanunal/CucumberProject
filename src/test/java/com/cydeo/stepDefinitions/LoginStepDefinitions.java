package com.cydeo.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("Librarian username");
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("Librarian password");
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("Librarian dashboard");
    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        System.out.println("Student username");
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        System.out.println("Student password");
    }

    @When("user enters admin username")
    public void userEntersAdminUsername() {
        System.out.println("Admin username");
    }

    @And("user enters admin password")
    public void userEntersAdminPassword() {
        System.out.println("Admin password");
    }

    @Given("user is on the library login page")
    public void userIsOnTheLibraryLoginPage() {
        System.out.println("user is on the library login page");
    }
}


