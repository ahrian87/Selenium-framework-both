package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    @FindBy(css="a[title='Home'][style='border: medium none;']")
    WebElement pageLogo;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnPageLogo() {
        WaitForElement.waitUntilElementIsClickable(pageLogo);
        pageLogo.click();
    }
}
