package com.cydeo.stepDefinitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

// Tn this clas, we will be able to pass pre and post conditions to each scenario and each step
public class Hooks {


    //implement from io.cucumber.java not from j.unit, so annotations could come from Cucumber
    //@Before(order = 1)
    public void setupScenario() {
        System.out.println("Setting up the browser using cucumber @Before");
    }

    //This will only apply to scenarios with @login tag
    //@Before(value = "@login", order = 2)
    public void setupScenarioForLogins() {
        System.out.println("This will only apply to scenarios with @login tag");
    }

    //This will only apply to scenarios with @db annotation tag
    //@Before(value = "@db", order = 0)
    public void setupForDatabaseScenarios() {
        System.out.println("This will only apply to scenarios with @db tag");
    }

    //implement from io.cucumber.java not from j.unit
    static  int i = 1;

    @After
    public void tearDownScenario(Scenario scenario) throws IOException { //use the Scenario from cucumber-java
        //Scenario keeps track of my currently executed scenario. Cucumber is following which scenario is being executed
        //This info is kept in the Scenario class object.
        //Create an if condition: Take a screenshot only when the scenario fails


        //scenario.isFailed() --> if scenario fails, this method will return TRUE boolen value
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            // This attaches our screenshot to the scenario
            // (get the screenshots from here, save them as png, write the scenario name)

            //This takes screenshots and saves them into the specified folder with the path
//            File file = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
//            FileHandler.copy(file, new File("ScreenShot" + "screenShot" + i + ".png"));
//            i++;

        }

        //BrowserUtils.sleep(3);
        Driver.closeDriver();

        //System.out.println("Closing the browser using cucumber @After");
        //System.out.println("Scenario failed, get a screenshot");
    }

    //implement from io.cucumber.java not from j.unit
    //@BeforeStep
    public void setupStep() {
        System.out.println("Using @BeforeStep");
    }

    //implement from io.cucumber.java not from j.unit
    //@AfterStep
    public void afterStep() {
        System.out.println("Using @AfterStep");
    }
}
