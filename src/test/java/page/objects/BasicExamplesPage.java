package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class BasicExamplesPage {

    @FindBy(css="a[href='./basic-first-form-demo.html'][class='list-group-item']")
    private WebElement simpleFormDemoButton;

    @FindBy(css="a[href='./basic-checkbox-demo.html'][class='list-group-item']")
    private WebElement checkBoxDemoButton;

    @FindBy(css="a[href='./basic-radiobutton-demo.html'][class='list-group-item']")
    private WebElement radioButtonsDemoButton;

    @FindBy(css="a[href='./basic-select-dropdown-demo.html'][class='list-group-item']")
    private WebElement selectDropdownListButton;

    @FindBy(css="a[href='./javascript-alert-box-demo.html'][class='list-group-item']")
    private WebElement javascriptAlertsButton;

    @FindBy(css="a[href='./window-popup-modal-demo.html'][class='list-group-item']")
    private WebElement windowPopupModalButton;

    @FindBy(css="a[href='./boostrap-alert-messages-demo.html'][class='list-group-item']")
    private WebElement bootstrapAlertsButton;

    @FindBy(css="a[href='./bootstrap-modal-demo.html'][class='list-group-item']")
    private WebElement bootstrapModalsButton;


    public BasicExamplesPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickSimpleFormDemoButton() {
        WaitForElement.waitUntilElementIsClickable(simpleFormDemoButton);
        simpleFormDemoButton.click();
    }

    public void clickCheckBoxDemoButton() {
        WaitForElement.waitUntilElementIsClickable(checkBoxDemoButton);
        checkBoxDemoButton.click();
    }

    public void clickRadioButtonsDemoButton() {
        WaitForElement.waitUntilElementIsClickable(radioButtonsDemoButton);
        radioButtonsDemoButton.click();
    }

    public void clickSelectDropdownListButton() {
        WaitForElement.waitUntilElementIsClickable(selectDropdownListButton);
        selectDropdownListButton.click();
    }

    public void clickJavascriptAlertsButton() {
        WaitForElement.waitUntilElementIsClickable(javascriptAlertsButton);
        javascriptAlertsButton.click();
    }

    public void clickWindowPopupModalButton() {
        WaitForElement.waitUntilElementIsClickable(windowPopupModalButton);
        windowPopupModalButton.click();
    }

    public void clickBootstrapAlertsButton() {
        WaitForElement.waitUntilElementIsClickable(bootstrapAlertsButton);
        bootstrapAlertsButton.click();
    }

    public void clickBootstrapModalsButton() {
        WaitForElement.waitUntilElementIsClickable(bootstrapModalsButton);
        bootstrapModalsButton.click();
    }
}
