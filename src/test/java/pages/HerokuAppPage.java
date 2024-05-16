package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuAppPage {

    public HerokuAppPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div#start>button")
    public WebElement startButton;

    @FindBy(css = "div#finish>h4")
    public WebElement message;

    @FindBy(xpath = "//*[contains(text(), 'Example 1')]")
    public WebElement exampleOneLink;

    @FindBy(xpath = "//*[contains(text(), 'Example 2')]")
    public WebElement exampleTwoLink;

}
