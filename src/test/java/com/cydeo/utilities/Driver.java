package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    // private constructor to close access to the object of this class from outside the class
    private Driver() {
    }

    // We make our driver private because we want to close access to the object of this class from outside the class
    // We make it static because we will use it in a static method, static belongs to the class no need to create object
    // to use it, static runs before everything else etc.
    // private static WebDriver driver; // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    //Create a re-usable utility method which will return the same driver instance when we call it.
    public static WebDriver getDriver() { //to give access to the driver, we create the method public
        // We read our browserType from the ConfigurationReader.properties where we can get our browser type.
        // This way, we can control which browser is opened from outside our code, from ConfigurationReader.properties
        // We let our Configuration.properties file to determine what kind of Browser will be opening

        // If there is no driver, it will come here and create a driver
        if (driverPool.get() == null) {   //Check if there is a driver. If there is not a driver, create me a browser driver
            String browserType = ConfigurationReader.getProperty("browser");

            //Depending on the browserType, switch will return the related driver from configuration.properties file
            switch (browserType) {
                case "chrome":          //If the browser type is Chrome
                    WebDriverManager.chromedriver().setup(); // we are using bonigarcia dependency here, in companies this may change
                    //driver = new ChromeDriver(); Instead of this
                    driverPool.set(new ChromeDriver());
                    //driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":         //If the browser type is Firefox
                    WebDriverManager.firefoxdriver().setup();
                    //driver = new FirefoxDriver(); Instead of this, use this:
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":            //If the browser type is Edge
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "remote-chrome":          //If the browser type is Chrome
                    ChromeOptions chromeOptions = new ChromeOptions();
                    try {
                        URL url = new URL("http://54.146.160.130/wd/hub");
                        driverPool.set(new RemoteWebDriver(url, chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    //driverPool.get().manage().window().maximize();
                    //driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "remote-firefox":         //If the browser type is Firefox
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    try {
                        URL url = new URL("http://54.146.160.130/wd/hub");
                        driverPool.set(new RemoteWebDriver(url, firefoxOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    //driverPool.get().manage().window().maximize();
                    //driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }


        // If the driver is NOT null, don't go in the switch block and just return me the existing driver
        return driverPool.get();
    }


    //driver.quit() --> NuSuchSession
    //driver.close() --> No session ID
    //Create a new utility method. This method will make sure (1)our driver value is always set to null after (2)using .quit() method
    //Basically, it has two functions => terminating the session and setting the driver to null so that in getDriver method
    public static void closeDriver() {
        if (driverPool.get() != null) { //if there is an existing session
            driverPool.get().quit();// terminate the existing session. Value will not even be null
            driverPool.remove(); // we will be setting our driver value to null ourselves to make sure it will be null again after quitting driver
        }
    }
}
