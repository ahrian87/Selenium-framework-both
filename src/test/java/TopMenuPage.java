import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage {

    private WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPageLogo() {
        WebElement pageLogo = driver.findElement(By.cssSelector("a[title='Home'][style='border: medium none;']"));
        pageLogo.click();
    }
}
