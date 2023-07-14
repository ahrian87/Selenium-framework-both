package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormPage {

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


    public SimpleFormPage(WebDriver driver) {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoInputMessageField(String message) {
        inputMessageField.sendKeys(message);
    }

    public void clickShowMessageButton() {
        showMessageButton.click();
    }

    public String getMessage() {
        String message = showMessageValue.getText();
        return message;
    }

    public void typeIntoEnterAInputField(String aInput) {
        enterAInputField.sendKeys(aInput);
    }

    public void typeIntoEnterBInputField(String bInput) {
        enterBInputField.sendKeys(bInput);
    }

    public void clickGetTotalButton() {
        getTotalButton.click();
    }

    public String getTotalValue() {
        String totalValue = totalValueMessage.getText();
        return totalValue;
    }

}
