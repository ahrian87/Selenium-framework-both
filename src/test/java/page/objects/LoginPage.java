package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(css="[class='page-title']")
    WebElement welcomeMessage;

    @FindBy(css="[name='Email']")
    WebElement emailField;

    @FindBy(css="[name='Password']")
    WebElement passwordField;

    @FindBy(css="[class='button-1 login-button']")
    WebElement loginButton;

    @FindBy(css="[class='validation-summary-errors']")
    WebElement loginSummaryError;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getWelcomeMessageTest() {
        return welcomeMessage.getText();
    }

    public void typeIntoEmailField(String emailAddress) {
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.clear();
        emailField.sendKeys(emailAddress);
        logger.info("Wprowadzono adres email: {}", emailAddress);
    }

    public void typeIntoPasswordField(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Wprowadzono hasło");
    }

    public void clickLoginButton() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Kliknięto przycisk Login");
    }

    public String getErrorMessage() {
        WaitForElement.waitUntilElementHasText(loginSummaryError);
        return loginSummaryError.getText();
    }
}
