package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    static String browserType;
    //we are closing access from outside the class
    private Driver() {
    }

    //we make it private because we want to close access from outside
    //we make it static because we're gonna use it in a static method
    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    //create a re-usable utility method which will return same driver instance when we call it.
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            //depending on the browsertype that we write in .properties file
            if (System.getProperty("BROWSER") == null) {
                browserType = ConfigurationReader.getProperty("browser");
            } else{
                browserType= System.getProperty("BROWSER");
            }
            switch (browserType) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set( new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":

                    try {
                        // assign your grid server address
                        String gridAddress = "";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set( new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set( new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    driverPool.get().manage().window().setSize(new Dimension(1500, 1500));
                    //driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }
}



//package com.cydeo.utilities;
//
//import com.cydeo.utilities.ConfigurationReader;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//public class Driver {
//
//    /*
//    Creating a private constructor, so we are closing
//    access to the object of this class from outside the class
//     */
//    private Driver(){}
//
//    /*
//    We make WebDriver private, because we want to close access from outside the class.
//    We make it static because we will use it in a static method.
//     */
//    //private static WebDriver driver; // value is null by default
//
//    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
//
//    /*
//    Create a re-usable utility method which will return same driver instance when we call it
//     */
//    public static WebDriver getDriver(){
//
//        if (driverPool.get() == null){
//
//            /*
//            We read our browserType from configuration.properties.
//            This way, we can control which browser is opened from outside our code, from configuration.properties.
//             */
//            String browserType = ConfigurationReader.getProperty("browser");
//
//
//            /*
//                Depending on the browserType that will be return from configuration.properties file
//                switch statement will determine the case, and open the matching browser
//            */
//            switch (browserType){
//                case "chrome":
//
//                    WebDriverManager.chromedriver().setup();
//                    driverPool.set(new ChromeDriver());
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverPool.set(new FirefoxDriver());
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//                case "remote-chrome":
//                    // assign your grid server address
//                    String gridAdress = "52.90.112.238"; // put your own Linux grid IP here
//                    try {
//                        URL url = new URL("http://"+gridAdress+":4444/wd/hub");
//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setBrowserName("chrome");
//                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
//                        driverPool.get().manage().window().maximize();
//                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case "saucelab-chrome":
//                    try{
//                        URL url = new URL("https://oauth-sdetoscar-844c8:66e7117f-390e-4556-8105-07af96a01f7a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setBrowserName("chrome");
//                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
//                        driverPool.get().manage().window().maximize();
//                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    }catch (MalformedURLException e){
//                        e.printStackTrace();
//                    }
//
//                    break;
//                case "saucelab-edge":
//                    EdgeOptions browserOptions = new EdgeOptions();
//                    browserOptions.setCapability("platformName", "Windows 11");
//                    browserOptions.setCapability("browserVersion", "latest");
//                    Map<String, Object> sauceOptions = new HashMap<>();
//                    sauceOptions.put("build", "<your build id>");
//                    sauceOptions.put("name", "<your test name>");
//                    browserOptions.setCapability("sauce:options", sauceOptions);
//
//                    URL url = null;
//                    try {
//                        url = new URL("https://oauth-sdetoscar-844c8:66e7117f-390e-4556-8105-07af96a01f7a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//                        driverPool.set(new RemoteWebDriver(url,browserOptions));
//                        driverPool.get().manage().window().maximize();
//                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//
//            }
//
//        }
//
//        return driverPool.get();
//
//    }
//
//    /*
//    This method will make sure our driver value is always null after using quit() method
//     */
//    public static void closeDriver(){
//        if (driverPool.get() != null){
//            driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
//            driverPool.remove();
//        }
//    }
//
//}
//
//
//
//
////package com.cydeo.utilities;
////
////import io.github.bonigarcia.wdm.WebDriverManager;
////import org.openqa.selenium.Dimension;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.chrome.ChromeDriver;
////import org.openqa.selenium.chrome.ChromeOptions;
////import org.openqa.selenium.edge.EdgeDriver;
////import org.openqa.selenium.firefox.FirefoxDriver;
////import org.openqa.selenium.firefox.FirefoxOptions;
////import org.openqa.selenium.remote.DesiredCapabilities;
////import org.openqa.selenium.remote.RemoteWebDriver;
////
////import java.net.MalformedURLException;
////import java.net.URL;
////import java.util.concurrent.TimeUnit;
////
////public class Driver {
////
////    // private constructor to close access to the object of this class from outside the class
////    private Driver() {
////    }
////
////    // We make our driver private because we want to close access to the object of this class from outside the class
////    // We make it static because we will use it in a static method, static belongs to the class no need to create object
////    // to use it, static runs before everything else etc.
////
////    private static WebDriver driver; // value is null by default
////
////    //Create a re-usable utility method which will return the same driver instance when we call it.
////    public static WebDriver getDriver() { //to give access to the driver, we create the method public
////        // We read our browserType from the ConfigurationReader.properties where we can get our browser type.
////        // This way, we can control which browser is opened from outside our code, from ConfigurationReader.properties
////        // We let our Configuration.properties file to determine what kind of Browser will be opening
////
////        // If there is no driver, it will come here and create a driver
////        if (driver == null) {   //Check if there is a driver. If there is not a driver, create me a browser driver
////            String browserType = ConfigurationReader.getProperty("browser");
////
////            //Depending on the browserType, switch will return the related driver from configuration.properties file
////            switch (browserType) {
////                case "chrome":          //If the browser type is Chrome
////                    WebDriverManager.chromedriver().setup(); // we are using bonigarcia dependency here, in companies this may change
////                    driver = new ChromeDriver();
////                    driver.manage().window().maximize();
////                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////                    driver.manage().window().setSize(new Dimension(1500, 1500));
////                    break;
////                case "firefox":         //If the browser type is Firefox
////                    WebDriverManager.firefoxdriver().setup();
////                    driver = new FirefoxDriver();
////                    driver.manage().window().maximize();
////                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////                    break;
////                case "edge":            //If the browser type is Edge
////                    WebDriverManager.edgedriver().setup();
////                    driver = new EdgeDriver();
////                    driver.manage().window().maximize();
////                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////                    break;
////            }
////        }
////
////        // If the driver is NOT null, don't go in the switch block and just return me the existing driver
////        return driver;
////    }
////
////
////    //driver.quit() --> NuSuchSession
////    //driver.close() --> No session ID
////    //Create a new utility method. This method will make sure (1)our driver value is always set to null after (2)using .quit() method
////    //Basically, it has two functions => terminating the session and setting the driver to null so that in getDriver method
////    public static void closeDriver() {
////        if (driver != null) { //if there is an existing session
////            driver.quit();// terminate the existing session. Value will not even be null
////            driver.close();
////
////            //driver.remove() is for many threads
////            //driver.remove(); // we will be setting our driver value to null ourselves to make sure it will be null again after quitting driver
////        }
////    }
////}
