package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class BasicExamplesPage {
    private Logger logger = LogManager.getRootLogger();

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

    @FindBy(css="a[href='./bootstrap-alert-messages-demo.html'][class='list-group-item']")
    private WebElement bootstrapAlertsButton;

    @FindBy(css="a[href='./bootstrap-modal-demo.html'][class='list-group-item']")
    private WebElement bootstrapModalsButton;


    public BasicExamplesPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickSimpleFormDemoButton() {
        WaitForElement.waitUntilElementIsClickable(simpleFormDemoButton);
        simpleFormDemoButton.click();
        logger.info("Clicked on Simple Form Demo button");
    }

    public void clickCheckBoxDemoButton() {
        WaitForElement.waitUntilElementIsClickable(checkBoxDemoButton);
        checkBoxDemoButton.click();
        logger.info("Clicked on Check Box Demo button");
    }

    public void clickRadioButtonsDemoButton() {
        WaitForElement.waitUntilElementIsClickable(radioButtonsDemoButton);
        radioButtonsDemoButton.click();
        logger.info("Clicked on Radio Buttons Demo button");
    }

    public void clickSelectDropdownListButton() {
        WaitForElement.waitUntilElementIsClickable(selectDropdownListButton);
        selectDropdownListButton.click();
        logger.info("Clicked on Select Dropdown List button");
    }

    public void clickJavascriptAlertsButton() {
        WaitForElement.waitUntilElementIsClickable(javascriptAlertsButton);
        javascriptAlertsButton.click();
        logger.info("Clicked on Javascript Alerts button");
    }

    public void clickWindowPopupModalButton() {
        WaitForElement.waitUntilElementIsClickable(windowPopupModalButton);
        windowPopupModalButton.click();
        logger.info("Clicked on Window Popup Modal button");
    }

    public void clickBootstrapAlertsButton() {
        WaitForElement.waitUntilElementIsClickable(bootstrapAlertsButton);
        bootstrapAlertsButton.click();
        logger.info("Clicked on Bootstrap Alerts button");
    }

    public void clickBootstrapModalsButton() {
        WaitForElement.waitUntilElementIsClickable(bootstrapModalsButton);
        bootstrapModalsButton.click();
        logger.info("Clicked on Bootstrap Modals button");
    }
}
