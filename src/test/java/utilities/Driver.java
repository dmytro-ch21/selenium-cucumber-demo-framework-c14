package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Singleton design pattern implementation rules
public class Driver {

    // 1. Private static member of the class
    private static WebDriver driver;

    // 2. Make the constructor private so no one can create objects
    private Driver(){}

    // 3. Make a static getter method that will allow to access the private property
    public static WebDriver getDriver(){
        if(driver == null){
            driver = DriverFactory.getDriver("chrome");
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
