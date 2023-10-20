package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class WindowPopupPage {

    public WindowPopupPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    String mainWindowHandle = DriverManager.getWebDriver().getWindowHandle();

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[contains(text(), 'Follow On Twitter')]")
    WebElement followOnTwitterButton;

    @FindBy(xpath = "//*[contains(text(), 'Like us On Facebook')]")
    WebElement likeUsOnFacebookButton;

    public void clickFollowOnTwitterButton() {
        WaitForElement.waitUntilElementIsClickable(followOnTwitterButton);
        followOnTwitterButton.click();
        logger.info("Click Follow On Twitter button");
    }

    public void clickLikeUsOnFacebookButton() {
        WaitForElement.waitUntilElementIsClickable(likeUsOnFacebookButton);
        likeUsOnFacebookButton.click();
        logger.info("Click Like us On Facebook button");
    }
}
