package tests;

import org.testng.annotations.Test;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.Random;

public class StoreRegisterFunctionalityTests extends TestBase {

    @Test
    public void test1(){
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();


        Random random= new Random();
        int emailId = random.nextInt(100000);
        String email = "abc"+emailId+"@gmail.com";
        storeAppLoginPage.emailBox.sendKeys(email);
        storeAppHomePage.loginButton.click();

    }


}
