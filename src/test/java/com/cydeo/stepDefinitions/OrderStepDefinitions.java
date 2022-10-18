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
import org.openqa.selenium.support.ui.WebDriverWait;
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
        webTablesPage.inputUsername.sendKeys("Test");
        webTablesPage.inputPassword.sendKeys("Tester");
        webTablesPage.loginButton.click();
//        webTablesPage.login(); //this method passes Test and tester as credentials, here we call the method to log in to the app

//        Actions actions = new Actions(Driver.getDriver());
////        actions.doubleClick(basePage.clickBeforeAll).perform();
////        actions.moveToElement(basePage.order).perform();
//        actions.click(basePage.order).perform();

       // JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
       // executor.executeScript("arguments[0].scrollIntoView(true);", basePage.order);
        BrowserUtils.sleep(10);

        basePage.order.click();


        //clicking the order link
        //basePage.order.click();
        System.out.println("user is on the order page = " + "user is on the order page");
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);
        System.out.println("user selects product type {string} = " + "user selects product type {string}");
    }

    @When("user enters quantity {string}")
    public void user_enters_quantity(String string) {

        //back_space will clear the existing input int the box
        //orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE); // more accurate than .clear()
        //orderPage.quantity.sendKeys(string);

        Actions actions = new Actions(Driver.getDriver());
        actions.click(orderPage.quantity).sendKeys(Keys.BACK_SPACE).sendKeys(string).perform();

//        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
//        executor.executeScript("arguments[0].setAttribute('value', 'string')", orderPage.inputQuantity);

        System.out.println("user enters quantity {string} = " + "user enters quantity {string}");
    }

    @When("user enters name {string}")
    public void user_enters_name(String string) {
        orderPage.inputName.sendKeys(string);
        System.out.println("user enters name {string} = " + "user enters name {string}");
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
        System.out.println("user enters street {string}");
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);
        System.out.println("user enters city {string} = " + "user enters city {string}");
    }


    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);
        System.out.println("user enters state {string}");
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
        System.out.println("user enters zipcode {string}");
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
        System.out.println("user selects card {string} = " + "user selects card {string}");

    }

    @When("user enters card number {string}")
    public void user_enters_card_number(String string) {
        orderPage.inputCardNo.sendKeys(string);
        System.out.println("user enters card number {string}");
    }

    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String string) {
        orderPage.inputCardExp.sendKeys(string);
        System.out.println("user enters expiration date {string}");
    }

    @When("user clicks process order button")
    public void user_clicks_process_order_button() {
        orderPage.processOrderButton.click();
        System.out.println("user clicks process order button.");
    }

    @Then("user should see {string} in the first row of the web table")
    public void user_should_see_in_the_first_row_of_the_web_table(String expectedCustomerName) {
        String actualCustomerName = viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedCustomerName, actualCustomerName);
        System.out.println("user should see {string} in the first row of the web table");
    }


}
