package step_definitions;


// The hooks work in this way.
// Cucumber will scan the step definition package
// If it finds any of these annotations it will use them

import com.sun.jdi.request.DuplicateRequestException;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;
import java.util.Arrays;

public class Hooks {

    // In cucumber we can use hooks at 3 levels
    // - Before and After all scenarios. - @BeforeAll and @AfterAll (the methods should be static)
    // - Before and After each scenario. - @Before and After(the methods should be instance)
    // - Before and After each step. - @BeforeStep and AfterStep(the methods should be instance)

    // We will use the Before and After Scenario
    @Before
    public void setUp(){
        // Apply Implicit wait
        // Implicit wait waits until the element can be located in dom
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Maximize the window
        //Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        // we need to know if scenario failed
        if(scenario.isFailed()){
            // take screenshot
            // Here is the logic of the screenshot:
            // We will need to downcast the driver to a TakesScreenshot type from selenium. (The relationship is already there)
            // Further, the object that we downcasted will have one useful method called - getScreenshot()
            // Inside of this method we specify the output type of the screenshot, commonly we use OutputType.BYTES
            // Lastly we assign the result to an byte array that is final
            final byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // Next we need to attach the screenshot to the report
            scenario.attach(screenshot, "image/jpeg","screenshot");
        }

        Driver.quitDriver();
    }




}
