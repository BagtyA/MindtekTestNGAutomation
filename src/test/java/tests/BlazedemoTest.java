package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazedemoFlightsPage;
import pages.BlazedemoHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;

public class BlazedemoTest extends TestBase {
    

    /*
    1. @BeforeMethod
    2. @Test
    3. @AfterMethod
     */

    @Test(groups={"regression"})
    public void test1(){
        BlazedemoHomePage blazeDemoHomePage= new BlazedemoHomePage();
        BlazedemoFlightsPage blazedemoFlightsPage= new BlazedemoFlightsPage();
     driver.get(ConfigReader.getProperty("BlazedemoURL"));
     blazeDemoHomePage.findFlightsButton.click();
     // validate all prices in table are below $1000
        List<WebElement> prices= blazedemoFlightsPage.prices;

        for (WebElement element : prices){
            String  priceStr = element.getText();  // $472.56-> int== Integer.parseInt(String);->int
                                                  // $472.56-> 472.56 priceStr=priceString(1);
            priceStr=priceStr.substring(1);
            double priceDouble = Double.parseDouble(priceStr);
            Assert.assertTrue(priceDouble<1000);
        }

    }
    @Test(groups ={"regression","smoke"})
    public void test2(){
        BlazedemoHomePage blazeDemoHomePage= new BlazedemoHomePage();
        BlazedemoFlightsPage blazedemoFlightsPage= new BlazedemoFlightsPage();
        driver.get(ConfigReader.getProperty("BlazedemoURL"));

        Select select = new Select(blazeDemoHomePage.fromCityDropdown);
        select.selectByVisibleText("Boston");
        select = new Select(blazeDemoHomePage.toCityDropdown);
        select.selectByVisibleText("London");
        blazeDemoHomePage.findFlightsButton.click();
        String actualText = blazedemoFlightsPage.headerText.getTitle();
        String expectedText = "Flight from Boston to London";
        Assert.assertEquals(actualText,expectedText);

    }


}
