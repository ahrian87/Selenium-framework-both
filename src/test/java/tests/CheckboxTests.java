package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.CheckboxPage;
import page.objects.LandingPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CheckboxTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/");
    }

    @Test
    public void singleCheckboxTest() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnStartButton();
        sleep();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage(driver);
        basicExamplesPage.clickCheckBoxDemoButton();
        sleep();

        CheckboxPage checkboxPage = new CheckboxPage(driver);
        checkboxPage.clickOnFirstCheckbox();
        sleep();

        assertTrue(checkboxPage.isSuccessMessageDisplayed());
    }

    private void sleep() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
