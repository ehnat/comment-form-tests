package aero.smart4aviation.www;

import aero.smart4aviation.www.configuration.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestCase {

    WebDriver driver;

    @BeforeMethod
    public void openChromeBrowser() throws Exception {
        driver = Browser.valueOf(System.getProperty("browser")).newDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() throws Exception {
        driver.quit();
    }
}
