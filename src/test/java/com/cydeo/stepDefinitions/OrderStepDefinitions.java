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
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
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
        Driver.getDriver().get(ConfigurationReader.getProperty("webTablesURL"));
        webTablesPage.login(); //this method passes Test and tester as credentials, here we call the method to log in to the app

//        Actions actions = new Actions(Driver.getDriver());
//        actions.doubleClick(basePage.order).perform();

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", basePage.order);
        basePage.order.click();


        //clicking the order link
        //basePage.order.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);
    }

    @When("user enters quantity {string}")
    public void user_enters_quantity(String string) {

        //back_space will clear the existing input int the box
        //orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE); // more accurate than .clear()
        //orderPage.quantity.sendKeys(string);

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].setAttribute('value', 'string')", orderPage.inputQuantity);

    }

    @When("user enters name {string}")
    public void user_enters_name(String string) {
        orderPage.inputName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }

    @When("user selects card {string}")
    public void user_selects_card(String expectedCardType) {
        List<WebElement> cardTypes = orderPage.cardType; //Get all the types of cards
//
//        for (WebElement cardType : cardTypes) {
//            if (cardType.getAttribute("value").equalsIgnoreCase(expectedCardType)){
//                cardType.click();
//            }
//        }

        //OR

        BrowserUtils.clickRadioButton(cardTypes, expectedCardType);

    }

    @When("user enters card number {string}")
    public void user_enters_card_number(String string) {
        orderPage.inputCardNo.sendKeys(string);
    }

    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String string) {
        orderPage.inputCardExp.sendKeys(string);
    }

    @When("user clicks process order button")
    public void user_clicks_process_order_button() {
        orderPage.processOrderButton.click();
    }

    @Then("user should see {string} in the first row of the web table")
    public void user_should_see_in_the_first_row_of_the_web_table(String expectedCustomerName) {
        String actualCustomerName = viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedCustomerName, actualCustomerName);
    }
}
