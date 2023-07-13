import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage {

    @FindBy(css="a[title='Home'][style='border: medium none;']")
    WebElement pageLogo;

    private WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPageLogo() {
        pageLogo.click();
    }
}
