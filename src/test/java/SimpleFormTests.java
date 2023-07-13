import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleFormTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com");
    }

    @Test
    public void fillingSimpleFormWithBasicTextTest() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnStartButton();
        sleep();
        BasicExamplesPage basicExamplesPage = new BasicExamplesPage(driver);
        basicExamplesPage.clickSimpleFormDemoButton();
        sleep();

        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        simpleFormPage.typeIntoInputMessageField("hello world");
        simpleFormPage.clickShowMessageButton();

        String message = simpleFormPage.getMessage();
        sleep();

        assertEquals(message, "hello world");
    }

    @Test
    public void fillingTwoInputFieldsFormTest() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnStartButton();
        sleep();
        BasicExamplesPage basicExamplesPage = new BasicExamplesPage(driver);
        basicExamplesPage.clickSimpleFormDemoButton();
        sleep();

        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        simpleFormPage.typeIntoEnterAInputField("2");
        simpleFormPage.typeIntoEnterBInputField("3");
        sleep();

        simpleFormPage.clickGetTotalButton();
        String totalValue = simpleFormPage.getTotalValue();

        assertEquals(totalValue, "5");
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
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
