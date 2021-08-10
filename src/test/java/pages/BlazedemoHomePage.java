package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazedemoHomePage {
    //
    //@FindBy

    public BlazedemoHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath ="//input[@class='btn btn-primary']")
                public WebElement findFlightsButton;

    @FindBy(name = "fromPort")
    public WebElement fromCityDropdown;

    @FindBy(name ="toPort")
    public WebElement toCityDropdown;



    }




