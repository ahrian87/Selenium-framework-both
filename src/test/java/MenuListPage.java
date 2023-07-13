import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuListPage {

    private WebDriver driver;

    public MenuListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnInputFormsLink() {
        WebElement inputFormsLink = driver.findElement(By.xpath("//ul[@id='treemenu']//a[contains(text(), 'Input Forms')]"));
        inputFormsLink.click();
    }

}
