package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage {
    public WebTablesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@name='username']")
    public WebElement inputUsername;

    @FindBy (css = "input[name='password']")
    public WebElement inputPassword;

    @FindBy (xpath = "//button[.='Login']")
    public WebElement loginButton;

    // No parameters, but when we call this method, it will directly login using the right credentials
    public void login(){
        this.inputUsername.sendKeys("Test");
        this.inputPassword.sendKeys("Tester");
        this.loginButton.click();
    }

    //This method accepts two arguments and logins
    public void login (String username, String password){
        //this.inputUsername.sendKeys(username);
        //this.inputPassword.sendKeys(password);
        //this.loginButton.click(); This olmasa da olur
        this.inputUsername.sendKeys(username);
        this.inputPassword.sendKeys(password);
        this.loginButton.click();
    }

    //This option logs in using credentials from configuration.properties
    public void loginWithConfig(String username, String password){
        inputUsername.sendKeys(ConfigurationReader.getProperty("webTablesUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("webTablesPassword"));
        loginButton.click();

    }

}
