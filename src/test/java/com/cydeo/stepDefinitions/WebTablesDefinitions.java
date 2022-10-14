package com.cydeo.stepDefinitions;

import com.cydeo.pages.WebTablesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebTablesDefinitions {

    WebTablesPage webTablesPage = new WebTablesPage();

    @Given("user is on the login page of the web table application")
    public void user_is_on_the_login_page_of_the_application() {
        String url = ConfigurationReader.getProperty("webTablesURL");
        Driver.getDriver().get(url);
    }
    @When("user enters username {string}")
    public void user_enters_username(String string) {
       webTablesPage.inputUsername.sendKeys(ConfigurationReader.getProperty("webTablesUsername"));
    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTablesPage.inputPassword.sendKeys(ConfigurationReader.getProperty("webTablesPassword"));
    }
    @When("user clicks to login")
    public void user_clicks_to_login() {
        webTablesPage.loginButton.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_order() {
        BrowserUtils.verifyURLContains("orders");
    }

    @When("user enters username {string} and password {string}, and logins")
    public void user_enters_username_and_password_and_logins(String username, String password) {
        webTablesPage.loginWithConfig(username, password);
    }

    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentialsComingFromFeatureFile) {
//        webTablesPage.inputUsername.sendKeys(credentialsComingFromFeatureFile.get("username"));
//        //This will get me the key username from the Map 'credentialsComingFromFeatureFile')
//
//        webTablesPage.inputPassword.sendKeys(credentialsComingFromFeatureFile.get("password"));
//        //This will get me the key username from the Map 'credentialsComingFromFeatureFile')
//
//        webTablesPage.loginButton.click();

        //OR

        webTablesPage.login(credentialsComingFromFeatureFile.get("username"), credentialsComingFromFeatureFile.get("password"));
        //We call our login utility method and pass values from the map

    }
}
