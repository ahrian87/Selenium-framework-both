package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css="[name='NewsletterEmail']")
    WebElement newsletterSignUp;

    @FindBy(css="[id='newsletter-subscribe-button']")
    WebElement subscribeButton;

    @FindBy(css="[class='newsletter-result-block']")
    WebElement newsletterResultBlock;

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public MainPage typeIntoNewsletterSignUp(String emailAddress){
        WaitForElement.waitUntilElementIsVisible(newsletterSignUp);
        newsletterSignUp.clear();
        newsletterSignUp.sendKeys(emailAddress);
        logger.info("Wprowadzono adres email: {}", emailAddress);
        return this;
    }

    public MainPage clickSubscribeButton() {
        WaitForElement.waitUntilElementIsClickable(subscribeButton);
        subscribeButton.click();
        logger.info("Kliknięto przycisk Subscribe");
        return this;
    }

    public String getNewsletterFieldValue() {
        WaitForElement.waitUntilElementHasText(newsletterSignUp);
        return newsletterSignUp.getAttribute("value");
    }

    public String getNewsletterSubscribeBlockMessage() {
        WaitForElement.waitUntilElementIsVisible(newsletterResultBlock);
        WaitForElement.waitUntilElementHasText(newsletterResultBlock);
        return newsletterResultBlock.getAttribute("outerText");
    }
}
