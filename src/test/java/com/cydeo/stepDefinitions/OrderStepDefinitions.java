package com.cydeo.stepDefinitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTablesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class OrderStepDefinitions {
    WebTablesPage webTablesPage = new WebTablesPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();

    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

    @Given("user is on the order page")
    public void user_is_on_the_order_page() {

        try {
            Driver.getDriver().get(ConfigurationReader.getProperty("webTablesURL"));
            webTablesPage.inputUsername.sendKeys("Test");
            webTablesPage.inputPassword.sendKeys("Tester");
            webTablesPage.loginButton.click();
            //webTablesPage.login(); //this method passes Test and tester as credentials, here we call the method to log in to the app

            //Actions actions = new Actions(Driver.getDriver());
            //actions.doubleClick(basePage.clickBeforeAll).perform();
            //actions.moveToElement(basePage.order).perform();
            //actions.click(basePage.order).perform();

            // JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            // executor.executeScript("arguments[0].scrollIntoView(true);", basePage.order);
            //BrowserUtils.sleep(10);

            //clicking the order link
            basePage.order.click();

        } catch (Error e){
            System.out.println("on the order page");
            e.printStackTrace();
        }


    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        try {
            Select select = new Select(orderPage.productDropdown);
            select.selectByVisibleText(string);
        } catch (Error e){
            System.out.println("product type");
            e.printStackTrace();
        }
    }

    @When("user enters quantity {string}")
    public void user_enters_quantity(String string) {

        try {
            //back_space will clear the existing input int the box
            //orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE); // more accurate than .clear()
            //orderPage.quantity.sendKeys(string);

            Actions actions = new Actions(Driver.getDriver());
            actions.click(orderPage.quantity).sendKeys(Keys.BACK_SPACE).sendKeys(string).perform();

            //JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            //executor.executeScript("arguments[0].setAttribute('value', 'string')", orderPage.inputQuantity);

        } catch (Error e){
            System.out.println("product type");
            e.printStackTrace();
        }

    }

    @When("user enters name {string}")
    public void user_enters_name(String string) {
        try{
        orderPage.inputName.sendKeys(string);
        } catch (Error e){
            System.out.println("name");
            e.printStackTrace();
        }

    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        try{
        orderPage.inputStreet.sendKeys(string);
        } catch (Error e){
            System.out.println("street");
            e.printStackTrace();
        }

    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        try{
        orderPage.inputCity.sendKeys(string);
        } catch (Error e){
            System.out.println("city");
            e.printStackTrace();
        }

    }


    @When("user enters state {string}")
    public void user_enters_state(String string) {
        try{
        orderPage.inputState.sendKeys(string);
        } catch (Error e){
            System.out.println("state");
            e.printStackTrace();
        }

    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        try{
        orderPage.inputZip.sendKeys(string);
        } catch (Error e){
            System.out.println("zipcode");
            e.printStackTrace();
        }

    }

    @When("user selects card {string}")
    public void user_selects_card(String expectedCardType) {
        try{
        List<WebElement> cardTypes = orderPage.cardType; //Get all the types of cards

        //for (WebElement cardType : cardTypes) {
        //    if (cardType.getAttribute("value").equalsIgnoreCase(expectedCardType)){
        //        cardType.click();
        //    }
        //}

        //OR

        BrowserUtils.clickRadioButton(cardTypes, expectedCardType);
        } catch (Error e){
            System.out.println("card");
            e.printStackTrace();
        }
    }

    @When("user enters card number {string}")
    public void user_enters_card_number(String string) {
        try{
        orderPage.inputCardNo.sendKeys(string);
        } catch (Error e){
            System.out.println("card no");
            e.printStackTrace();
        }

    }

    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String string) {
        try{
        orderPage.inputCardExp.sendKeys(string);
        } catch (Error e){
            System.out.println("exp date");
            e.printStackTrace();
        }

    }

    @When("user clicks process order button")
    public void user_clicks_process_order_button() {
        try{
        orderPage.processOrderButton.click();
        } catch (Error e){
            System.out.println("process button");
            e.printStackTrace();
        }

    }

    @Then("user should see {string} in the first row of the web table")
    public void user_should_see_in_the_first_row_of_the_web_table(String expectedCustomerName) {
        try{
        String actualCustomerName = viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedCustomerName, actualCustomerName);
        } catch (Error e){
            System.out.println("last");
            e.printStackTrace();
        }

    }


}
