package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class RegisterPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css="[class='page-title']")
    WebElement pageTitle;

    @FindBy(css="[id='gender-male']")
    WebElement genderMaleRadioButton;

    @FindBy(css="[id='gender-female']")
    WebElement genderFemaleRadioButton;

    @FindBy(css="[name='FirstName']")
    WebElement firstNameInputField;

    @FindBy(css="[name='LastName']")
    WebElement lastNameInputField;

    @FindBy(css="[name='Email']")
    WebElement emailInputField;

    @FindBy(css="[name='Password']")
    WebElement passwordInputField;

    @FindBy(css="[name='ConfirmPassword']")
    WebElement confirmPasswordInputField;

    @FindBy(css="[id='register-button']")
    WebElement registerAccountButton;

    public RegisterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickMaleRadioButton() {
        WaitForElement.waitUntilElementIsClickable(genderMaleRadioButton);
        genderMaleRadioButton.click();
        logger.info("Zaznaczono opcję Male");
    }

    public void clickFemaleRadioButton() {
        WaitForElement.waitUntilElementIsClickable(genderFemaleRadioButton);
        genderFemaleRadioButton.click();
        logger.info("Zaznaczono opcję Female");
    }

    public void typeIntoFirstNameField(String firstName) {
        WaitForElement.waitUntilElementIsClickable(firstNameInputField);
        WaitForElement.waitUntilElementIsVisible(firstNameInputField);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
        logger.info("Wprowadzono wartość w polu First name: {}", firstName);
    }

    public void typeIntoLastNameField(String lastName) {
        WaitForElement.waitUntilElementIsClickable(lastNameInputField);
        WaitForElement.waitUntilElementIsVisible(lastNameInputField);
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
        logger.info("Wprowadzono wartość w polu Last name: {}", lastName);
    }

    public void typeIntoEmailField(String email) {
        WaitForElement.waitUntilElementIsClickable(emailInputField);
        WaitForElement.waitUntilElementIsVisible(emailInputField);
        emailInputField.clear();
        emailInputField.sendKeys(email);
        logger.info("Wprowadzono wartość w polu Email: {}", email);
    }

    public void typeIntoPasswordField(String password) {
        WaitForElement.waitUntilElementIsClickable(passwordInputField);
        WaitForElement.waitUntilElementIsVisible(passwordInputField);
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
        logger.info("Wprowadzono wartość w polu Password");
    }

    public void confirmPassword(String password) {
        WaitForElement.waitUntilElementIsClickable(confirmPasswordInputField);
        WaitForElement.waitUntilElementIsVisible(confirmPasswordInputField);
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys(password);
        logger.info("Potwierdzono hasło");
    }

    public void clickRegisterAccountButton() {
        WaitForElement.waitUntilElementIsClickable(registerAccountButton);
        registerAccountButton.click();
        logger.info("Kliknięto przycisk Register");
    }

    public String getPageTitleValue() {
        WaitForElement.waitUntilElementHasText(pageTitle);
        return pageTitle.getText();
    }

}
