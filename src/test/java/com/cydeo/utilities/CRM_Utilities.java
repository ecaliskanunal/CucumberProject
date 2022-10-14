package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    //This method logins with helpdes1@cybertekschool.com username when it is called
    public static void crmLogin(WebDriver driver){

        //Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@type='text']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        //Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("UserUser");

        //Click to login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

    public static void crmLogin(WebDriver driver, String username, String password){

        //Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@type='text']"));
        inputUsername.sendKeys(username);

        //Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys(password);

        //Click to login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

}
