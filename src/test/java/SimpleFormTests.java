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
        driver.navigate().to("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }

    @Test
    public void fillingSimpleFormWithBasicTextTest() {
        WebElement inputMessageField = driver.findElement(By.cssSelector(".form-group #user-message"));
        inputMessageField.sendKeys("hello ssworld");

        WebElement showMessageButton = driver.findElement(By.xpath("//form[@id='get-input']/button"));
        showMessageButton.click();
        sleep();

        WebElement yourMessageDisplay = driver.findElement(By.xpath("//div[@id='user-message']/span"));

        assertEquals("hello ssworld", yourMessageDisplay.getAttribute("textContent"));
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
