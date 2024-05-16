package utilities;

import org.openqa.selenium.WebDriver;


// Singleton design pattern implementation rules
public class Driver {

    // 1. Private static member of the class
    private static WebDriver driver;

    // 2. Make the constructor private so no one can create objects
    private Driver(){}

    // 3. Make a static getter method that will allow to access the private property
    public static WebDriver getDriver(){
        // This method will check if driver is already instantiated, if no it will do so
        // This is also called Lazy Instantiation
        if(driver == null){
            driver = DriverFactory.getDriver(ConfigReader.getProperty("browserType"));
        }
        return driver;
    }

    // 4. Each singleton dp can be complimented with additional custom logic
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
