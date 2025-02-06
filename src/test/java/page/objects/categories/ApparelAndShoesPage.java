package page.objects.categories;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ApparelAndShoesPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(css="[class='page-title']")
    WebElement pageTitle;

    @FindBy(xpath="//h2[contains(@class, 'product-title')]//a[contains(@href, '/blue-and-green-sneaker')]")
    WebElement blueAndGreenSneaker;

    public ApparelAndShoesPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getPageTitle() {
        WaitForElement.waitUntilElementHasText(pageTitle);
        return pageTitle.getText();
    }

    public void clickBlueAndGreenSneaker() {
        WaitForElement.waitUntilElementIsClickable(blueAndGreenSneaker);
        blueAndGreenSneaker.click();
        logger.info("Kliknięto produkt Blue and green Sneaker1");
    }
}
