package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackDDTTest {
    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    @Before
    public void setUp(){
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void loginDDTTest() throws IOException {
        String filePath = "VyTrackUsers.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i = 1; i < sheet.getLastRowNum(); i++) { //will give us all the rows
            String username = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstName = sheet.getRow(i).getCell(2).toString();
            String lastName = sheet.getRow(i).getCell(3).toString();
            loginPage.login(username, password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));



            String actualFullname = dashboardPage.fullName.getText();
            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if (actualFullname.contains(firstName) && actualFullname.contains(lastName)){
                System.out.println("Pass");
                resultCell.setCellValue("Pass");
            }else{
                System.out.println("Fail");
                resultCell.setCellValue("Fail");
            }
            dashboardPage.logout();

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            workbook.close();
            fileOutputStream.close();
            fileInputStream.close();

        }




    }
}
