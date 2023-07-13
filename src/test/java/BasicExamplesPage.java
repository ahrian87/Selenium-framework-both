import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicExamplesPage {
    private WebDriver driver;

    public BasicExamplesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSimpleFormDemoButton() {
        WebElement simpleFormDemoButton = driver.findElement(By.cssSelector("a[href='./basic-first-form-demo.html'][class='list-group-item']"));
        simpleFormDemoButton.click();
    }

    public void clickCheckBoxDemoButton() {
        WebElement checkBoxDemoButton = driver.findElement(By.cssSelector("a[href='./basic-checkbox-demo.html'][class='list-group-item']"));
        checkBoxDemoButton.click();
    }

    public void clickRadioButtonsDemoButton() {
        WebElement radioButtonsDemoButton = driver.findElement(By.cssSelector("a[href='./basic-radiobutton-demo.html'][class='list-group-item']"));
        radioButtonsDemoButton.click();
    }

    public void clickSelectDropdownListButton() {
        WebElement selectDropdownListButton = driver.findElement(By.cssSelector("a[href='./basic-select-dropdown-demo.html'][class='list-group-item']"));
        selectDropdownListButton.click();
    }

    public void clickJavascriptAlertsButton() {
        WebElement javascriptAlertsButton = driver.findElement(By.cssSelector("a[href='./javascript-alert-box-demo.html'][class='list-group-item']"));
        javascriptAlertsButton.click();
    }

    public void clickWindowPopupModalButton() {
        WebElement windowPopupModalButton = driver.findElement(By.cssSelector("a[href='./window-popup-modal-demo.html'][class='list-group-item']"));
        windowPopupModalButton.click();
    }

    public void clickBootstrapAlertsButton() {
        WebElement bootstrapAlertsButton = driver.findElement(By.cssSelector("a[href='./boostrap-alert-messages-demo.html'][class='list-group-item']"));
        bootstrapAlertsButton.click();
    }

    public void clickBootstrapModalsButton() {
        WebElement bootstrapModalsButton = driver.findElement(By.cssSelector("a[href='./bootstrap-modal-demo.html'][class='list-group-item']"));
        bootstrapModalsButton.click();
    }
}
