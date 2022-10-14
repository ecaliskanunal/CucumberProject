package com.cydeo.stepDefinitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DataTableStepDefinitions {

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> favoriteFruits) {
        System.out.println(favoriteFruits);
    }


    @Given("user is on the dropdowns page")
    public void user_is_on_the_dropdowns_page() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    DropdownsPage dropdownsPage = new DropdownsPage();
    //We are creating here the object so that we can get the dropdowns.
    //We need to pass the web element (monthDropdown) into the constructor of Select class
    @Then("user should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) { // expectedMonths are coming from feature file
//        Select select = new Select(dropdownsPage.monthDropdown);
//        //I pass the web element for the months' dropdown into the constructor of Select class object
//
//        List<WebElement> actualOptionsAsWebElement = select.getOptions();
//        //This is returning me a list of web elements, but I need to pass it to the method parameter as a List of Strings
//
//        List<String> actualOptionsAsString = new ArrayList<>();
//        for (WebElement webElement : actualOptionsAsWebElement) {
//            actualOptionsAsString.add(webElement.getText());
//        }

        //Instead of these line above, we can use utility method
        //This method returns the List of String of given dropdown's options
        List<String> actualMonths = BrowserUtils.dropdownOptionsAsString(dropdownsPage.monthDropdown);

        Assert.assertEquals(expectedMonths, actualMonths);
        //Assert will check the size of the lists first. If it is matching, it will check content 1 by 1
    }


}
