package com.cydeo.stepDefinitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GoogleStepDefinitions {

    //I create the object of GoogleSearchPage POM in the class level, so I can call it in all the methods down below
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user types {string} and clicks enter") //Here, we can pass many arguments
    public void user_types_and_clicks_enter(String searchKeyword) { // We are allowed to pass it as an argument
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);
    }

    @Then("user sees {string} in the title")
    public void user_sees_in_the_title(String searchKeyword) {
        String expectedTitle = searchKeyword + " - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        //Junit assertion accepts the first arg as expected, second arg as actual - Order matters!!!
        Assert.assertEquals(expectedTitle, actualTitle, "Title is not as expected!");
    }

    @When("user is on the Google search page")
    public void userIsOnTheGoogleSearchPage() {
        Driver.getDriver().get("https://www.google.com");
        WebElement acceptButton = Driver.getDriver().findElement(By.xpath("(//div[@class=\"QS5gu sy4vM\"])[1]"));
        acceptButton.click();
    }

    @Then("user should see the title is Google")
    public void userShouldSeeTheTitleIsGoogle() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        //Junit assertion accepts the first arg as expected, second arg as actual - Order matters!!!
        Assert.assertEquals(expectedTitle, actualTitle, "Title is not as expected!");
    }

    @When("user types apple and clicks enter")
    public void userTypesAppleAndClicksEnter() {
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }

    @Then("user sees apple in the title")
    public void userSeesAppleInTheTitle() {
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        //Junit assertion accepts the first arg as expected, second arg as actual - Order matters!!!
        Assert.assertEquals(expectedTitle, actualTitle, "Title is not as expected!");

    }
}
