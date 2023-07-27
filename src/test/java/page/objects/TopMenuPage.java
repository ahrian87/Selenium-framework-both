package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css="a[title='Home'][style='border: medium none;']")
    WebElement pageLogo;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnPageLogo() {
        WaitForElement.waitUntilElementIsClickable(pageLogo);
        pageLogo.click();
        logger.info("Clicked on page logo");
    }
}
