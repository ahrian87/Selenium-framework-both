package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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


    public void clickJavaScriptAlertBoxButton() {
        WaitForElement.waitUntilElementIsClickable(javaScriptAlertBoxButton);
        javaScriptAlertBoxButton.click();
        logger.info("Click JavaScript Alert Box button");
    }

    public void clickJavaScriptConfirmBoxButton() {
        WaitForElement.waitUntilElementIsClickable(javaScriptConfirmBoxButton);
        javaScriptConfirmBoxButton.click();
        logger.info("Click JavaScript Confirm Box button");
    }

    public void clickJavaScriptPromptBoxButton() {
        WaitForElement.waitUntilElementIsClickable(javaScriptPromptBoxButton);
        javaScriptPromptBoxButton.click();
        logger.info("Click JavaScript Prompt Box button");
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

    public void sendKeysToPromptBox(String message) {
        waitForAlert();
        alert.sendKeys(message);
    }

    public void closeAlertBox() {
        alert.accept();
        logger.info("Close alert box with OK button");
    }

    public void dismissAlertBox() {
        alert.dismiss();
        logger.info("Close alert box with Cancel button");
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