package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class BootstrapAlertsPage {

    private Logger logger = LogManager.getRootLogger();

    public BootstrapAlertsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(id = "autoclosable-btn-success")
    WebElement autocloseableButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-autocloseable-success']")
    WebElement autocloseableMessage;

    public void clickAutocloseableButtonMessage() {
        WaitForElement.waitUntilElementIsClickable(autocloseableButton);
        autocloseableButton.click();
        logger.info("Click Autocloseable message button");
    }

    public boolean isAutocloseableMessageDisplayed() {
        logger.info("Check if the message is displayed");
        return autocloseableMessage.isDisplayed();
    }
}