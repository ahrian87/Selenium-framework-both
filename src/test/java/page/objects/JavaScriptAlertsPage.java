package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.OtherWaits;
import waits.WaitForElement;

public class JavaScriptAlertsPage {

    private Logger logger = LogManager.getRootLogger();

    Alert alert;

    @FindBy(xpath = "//button[@onclick='myAlertFunction()']")
    WebElement javaScriptAlertBoxButton;

    @FindBy(xpath = "//button[@onclick='myConfirmFunction()']")
    WebElement javaScriptConfirmBoxButton;

    @FindBy(css = "#confirm-demo")
    WebElement confirmationMessage;

    @FindBy(css = "#prompt-demo")
    WebElement promptBoxMessage;

    @FindBy(xpath = "//button[@onclick='myPromptFunction()']")
    WebElement javaScriptPromptBoxButton;

    public JavaScriptAlertsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public JavaScriptAlertsPage clickJavaScriptAlertBoxButton() {
        WaitForElement.waitUntilElementIsClickable(javaScriptAlertBoxButton);
        javaScriptAlertBoxButton.click();
        logger.info("Click JavaScript Alert Box button");
        return this;
    }

    public JavaScriptAlertsPage clickJavaScriptConfirmBoxButton() {
        WaitForElement.waitUntilElementIsClickable(javaScriptConfirmBoxButton);
        javaScriptConfirmBoxButton.click();
        logger.info("Click JavaScript Confirm Box button");
        return this;
    }

    public JavaScriptAlertsPage clickJavaScriptPromptBoxButton() {
        WaitForElement.waitUntilElementIsClickable(javaScriptPromptBoxButton);
        javaScriptPromptBoxButton.click();
        logger.info("Click JavaScript Prompt Box button");
        return this;
    }

    private void waitForAlert() {
        alert = DriverManager.getWebDriver().switchTo().alert();
        WaitForElement.waitUntilAlertIsVisible(alert);
        logger.info("Wait for alert to appear");
    }

    public boolean isAlertVisible() {
        waitForAlert();
        logger.info("Check if alert is displayed");
        return alert.getText() != null;
    }

    public JavaScriptAlertsPage sendKeysToPromptBox(String message) {
        waitForAlert();
        alert.sendKeys(message);
        logger.info("Text sent to prompt message box");
        return this;
    }

    public JavaScriptAlertsPage closeAlertBox() {
        alert.accept();
        logger.info("Close alert box with OK button");
        return this;
    }

    public JavaScriptAlertsPage dismissAlertBox() {
        alert.dismiss();
        logger.info("Close alert box with Cancel button");
        return this;
    }

    public String getConfirmationMessage() {
        WaitForElement.waitUntilElementIsVisible(confirmationMessage);
        logger.info("Confirmation message appears");
        return confirmationMessage.getText();
    }

    public String getPromptBoxMessage() {
        WaitForElement.waitUntilElementIsVisible(promptBoxMessage);
        logger.info("Get Prompt Box message");
        return promptBoxMessage.getText();
    }
}