package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {

    //This method returns the order date on the given customer name
    public static String returnOrderDate(WebDriver driver, String customerName) {
        String locator = "//td[.='"+ customerName +"']/following-sibling::td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));
        return customerDateCell.getText();
    }

//    //This method returns the order date on the given customer name
//    public static String returnOrderDateShortVersion (WebDriver driver, String customerName) {
//        return driver.findElement(By.xpath("//td[.=' " + customerName + " ']/following-sibling::td[3]")).getText();
//    }

    public static String returnAddress(WebDriver driver, String customerName) {
        String locator = "//td[.='"+ customerName +"']/following-sibling::td[4]";
        WebElement customerAddressCell = driver.findElement(By.xpath(locator));
        return customerAddressCell.getText();
    }

    public static void orderVerify (WebDriver driver, String customerName, String expectedOrderDate){
        //We use the method up here in this method
        String customerOrderDate = WebTableUtils.returnOrderDate(driver, customerName);
        Assert.assertEquals(customerOrderDate, expectedOrderDate);

    }
}
