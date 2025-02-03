package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class RightMenuPage {

    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(css="[name='NewsletterEmail']")
    WebElement newsletterSignUpField;

    @FindBy(css="[id='newsletter-subscribe-button']")
    WebElement subscribeButton;

    @FindBy(css="[class='newsletter-result-block']")
    WebElement newsletterResultBlock;

    @FindBy(css="#pollanswers-1")
    WebElement firstPollAnswerButton;

    @FindBy(css="#pollanswers-2")
    WebElement secondPollAnswerButton;

    @FindBy(css="#pollanswers-3")
    WebElement thirdPollAnswerButton;

    @FindBy(css="#pollanswers-4")
    WebElement fourthPollAnswerButton;

    @FindBy(css="[value='Vote']")
    WebElement votePollButton;

    public RightMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public RightMenuPage typeIntoNewsletterSignUp(String emailAddress){
        WaitForElement.waitUntilElementIsVisible(newsletterSignUpField);
        newsletterSignUpField.clear();
        newsletterSignUpField.sendKeys(emailAddress);
        logger.info("Wprowadzono adres email: {}", emailAddress);
        return this;
    }

    public RightMenuPage clickSubscribeButton() {
        WaitForElement.waitUntilElementIsClickable(subscribeButton);
        subscribeButton.click();
        logger.info("Kliknięto przycisk Subscribe");
        return this;
    }

    public String getNewsletterFieldValue() {
        WaitForElement.waitUntilElementHasText(newsletterSignUpField);
        return newsletterSignUpField.getAttribute("value");
    }

    public String getNewsletterSubscribeBlockMessage() {
        WaitForElement.waitUntilElementIsVisible(newsletterResultBlock);
        WaitForElement.waitUntilElementHasText(newsletterResultBlock);
        return newsletterResultBlock.getAttribute("outerText");
    }
}
