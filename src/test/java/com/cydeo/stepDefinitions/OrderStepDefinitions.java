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
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    @Given("user is on the order page")
    public void user_is_on_the_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTablesURL"));
        webTablesPage.login();
        //webTablesPage.login(); //this method passes Test and tester as credentials, here we call the method to log in to the app

        //executor.executeScript("arguments[0].scrollIntoView(true);", basePage.order);
        //BrowserUtils.sleep(10);

//        Actions actions = new Actions(Driver.getDriver());
//        //actions.moveToElement(basePage.order).perform();
//        actions.click(basePage.order).perform();

        //clicking the order link
        basePage.order.click();


    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.productDropdown);

        actions.moveToElement(orderPage.productDropdown).perform();
        actions.click(orderPage.productDropdown).perform();

        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);

    }

    @When("user enters quantity {string}")
    public void user_enters_quantity(String string) {

        //back_space will clear the existing input int the box
        //orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE); // more accurate than .clear()
        //orderPage.quantity.sendKeys(string);


        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.quantity);

        actions.click(orderPage.quantity).sendKeys(Keys.BACK_SPACE).sendKeys(string).perform();

        //JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        //executor.executeScript("arguments[0].setAttribute('value', 'string')", orderPage.inputQuantity);
    }

    @When("user enters name {string}")
    public void user_enters_name(String string) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.inputName);

        actions.moveToElement(orderPage.inputName).perform();
        actions.click(orderPage.inputName).sendKeys(string).perform();

    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.inputStreet);

        actions.moveToElement(orderPage.inputStreet).perform();
        actions.click(orderPage.inputStreet).sendKeys(string).perform();

        //orderPage.inputStreet.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.inputCity);

        actions.moveToElement(orderPage.inputCity).perform();
        actions.click(orderPage.inputCity).sendKeys(string).perform();

        //orderPage.inputCity.sendKeys(string);
    }


    @When("user enters state {string}")
    public void user_enters_state(String string) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.inputState);

        actions.moveToElement(orderPage.inputState).perform();
        actions.click(orderPage.inputState).sendKeys(string).perform();

        //orderPage.inputState.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.inputZip);

        actions.moveToElement(orderPage.inputZip).perform();
        actions.click(orderPage.inputZip).sendKeys(string).perform();

        //orderPage.inputZip.sendKeys(string);
    }

    @When("user selects card {string}")
    public void user_selects_card(String expectedCardType) {

        List<WebElement> cardTypes = orderPage.cardType; //Get all the types of cards

        //for (WebElement cardType : cardTypes) {
        //    if (cardType.getAttribute("value").equalsIgnoreCase(expectedCardType)){
        //        cardType.click();
        //    }
        //}

        //OR

        BrowserUtils.clickRadioButton(cardTypes, expectedCardType);

    }

    @When("user enters card number {string}")
    public void user_enters_card_number(String string) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.inputCardNo);

        actions.moveToElement(orderPage.inputCardNo).perform();
        actions.click(orderPage.inputCardNo).sendKeys(string).perform();

        //orderPage.inputCardNo.sendKeys(string);
    }

    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String string) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.inputCardExp);

        actions.moveToElement(orderPage.inputCardExp).perform();
        actions.click(orderPage.inputCardExp).sendKeys(string).perform();

        //orderPage.inputCardExp.sendKeys(string);
    }

    @When("user clicks process order button")
    public void user_clicks_process_order_button() {

        //executor.executeScript("arguments[0].scrollIntoView(true);", orderPage.processOrderButton);

        actions.moveToElement(orderPage.processOrderButton).perform();
        actions.click(orderPage.processOrderButton).perform();

        //orderPage.processOrderButton.click();
    }

    @Then("user should see {string} in the first row of the web table")
    public void user_should_see_in_the_first_row_of_the_web_table(String expectedCustomerName) {

        //executor.executeScript("arguments[0].scrollIntoView(true);", viewAllOrdersPage.newCustomerCell);
        String actualCustomerName = viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedCustomerName, actualCustomerName);
    }


}
