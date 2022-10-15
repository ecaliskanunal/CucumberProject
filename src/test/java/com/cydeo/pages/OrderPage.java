package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {
    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//form//div/select")
    public WebElement productDropdown;

    @FindBy(xpath = "//*[@id=\"root\"]/section/div/form/div/div[1]/div[1]/div[2]/div/input")
    public WebElement inputQuantity;

    @FindBy(xpath = "//div[2]/div[1]/div/input")
    public WebElement inputName;

    @FindBy(name = "street")
    public WebElement inputStreet;

    @FindBy(name = "city")
    public WebElement inputCity;

    @FindBy(name = "state")
    public WebElement inputState;

    @FindBy(name = "zip")
    public WebElement inputZip;

    @FindBy(name = "card") //We cannot use the text of input tag because it is not a paired tag
    public List<WebElement> cardType;

    @FindBy(name = "cardNo")
    public WebElement inputCardNo;

    @FindBy(name = "cardExp")
    public WebElement inputCardExp;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderButton;

    @FindBy(xpath = "//*[text() = 'MoneyCogFamilybeaScreenable']")
    public WebElement productSelect;


}
