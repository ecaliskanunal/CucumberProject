package com.cydeo.stepDefinitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class WikiStepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();
    @Given("user is on wiki home page")
    public void user_is_on_wiki_home_page() {
        Driver.getDriver().get(("https://www.wikipedia.org"));
    }

    @When("user types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String searchKeyword) {
        wikiSearchPage.searchBox.sendKeys(searchKeyword);
    }

    @When("user clicks search button")
    public void user_clicks_search_button() {
       wikiSearchPage.searchButton.click();
    }

    @Then("user sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    @Then("user sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String string) {
        Assert.assertTrue(wikiSearchPage.mainHeader.isDisplayed());
        Assert.assertTrue(wikiSearchPage.mainHeader.getText().equals(string));
    }

    @Then("user sees {string} is in the wiki image header")
    public void user_sees_is_in_the_wiki_image_header(String string) {

    }
}