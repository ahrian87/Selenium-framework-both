package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {


    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://demo.seleniumeasy.com/");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}