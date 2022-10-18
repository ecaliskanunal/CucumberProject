package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//In this class, we store WebElements common to all pages
public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//button[.='View all products']")
    public WebElement viewAllProducts;

    @FindBy (xpath = "//button[.='View all orders']")
    public WebElement viewAllOrders;



    @FindBy (xpath = "//*[@id='root']/nav/div[2]")
    public WebElement clickBeforeAll;

    @FindBy (css = "#root > nav > div.nav__items__wrap > a:nth-child(3) > button")
    public WebElement order;

    @FindBy (xpath = "//button[.='Logout']")
    public WebElement logout;

}
