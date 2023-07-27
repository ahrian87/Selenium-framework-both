package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class SimpleFormPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css=".form-group #user-message")
    WebElement inputMessageField;

    @FindBy(xpath="//form[@id='get-input']/button")
    WebElement showMessageButton;

    @FindBy(xpath="//div[@id='user-message']/span")
    WebElement showMessageValue;

    @FindBy(css="input[name='sum1']")
    WebElement enterAInputField;

    @FindBy(css="input[name='sum2']")
    WebElement enterBInputField;

    @FindBy(css="button[class='btn btn-primary'][onclick='return total()']")
    WebElement getTotalButton;

    @FindBy(css="#displayvalue")
    WebElement totalValueMessage;


    public SimpleFormPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoInputMessageField(String message) {
        WaitForElement.waitUntilElementIsVisible(inputMessageField);
        inputMessageField.sendKeys(message);
        logger.info("Typed into input message field - {}", message);
    }

    public void clickShowMessageButton() {
        showMessageButton.click();
        logger.info("Clicked on Show Message button");
    }

    public String getMessage() {
        return showMessageValue.getText();
    }

    public void typeIntoEnterAInputField(String aInput) {
        WaitForElement.waitUntilElementIsVisible(enterAInputField);
        enterAInputField.sendKeys(aInput);
        logger.info("Type into Enter A input field - {}", aInput);
    }

    public void typeIntoEnterBInputField(String bInput) {
        enterBInputField.sendKeys(bInput);
        logger.info("Type into Enter B input field - {}", bInput);
    }

    public void clickGetTotalButton() {
        getTotalButton.click();
        logger.info("Clicked on Get Total button");
    }

    public String getTotalValue() {
        return totalValueMessage.getText();
    }

}
