import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicExamplesPage {
    private WebDriver driver;

    public BasicExamplesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSimpleFormDemoButton() {
        WebElement simpleFormDemoButton = driver.findElement(By.cssSelector("a[href='./basic-first-form-demo.html'][class='list-group-item']"));
        simpleFormDemoButton.click();
    }
}
