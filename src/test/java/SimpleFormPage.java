import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormPage {
    private WebDriver driver;

    public SimpleFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeIntoInputMessageField() {
        WebElement inputMessageField = driver.findElement(By.cssSelector(".form-group #user-message"));
        inputMessageField.sendKeys("hello world");
    }

    public void clickShowMessageButton() {
        WebElement showMessageButton = driver.findElement(By.xpath("//form[@id='get-input']/button"));
        showMessageButton.click();
    }

    public String getMessage() {
        WebElement showMessageValue = driver.findElement(By.xpath("//div[@id='user-message']/span"));
        String message = showMessageValue.getText();
        return message;
    }

    public void typeIntoEnterAInputField() {
        WebElement enterAInputField = driver.findElement(By.cssSelector("input[name='sum1']"));
        enterAInputField.sendKeys("2");
    }

    public void typeIntoEnterBInputField() {
        WebElement enterBInputField = driver.findElement(By.cssSelector("input[name='sum2']"));
        enterBInputField.sendKeys("3");
    }

    public void clickGetTotalButton() {
        WebElement getTotalButton = driver.findElement(By.cssSelector("button[class='btn btn-primary'][onclick='return total()']"));
        getTotalButton.click();
    }

    public String getTotalValue() {
        WebElement totalValueMessage = driver.findElement(By.cssSelector("#displayvalue"));
        String totalValue = totalValueMessage.getText();
        return totalValue;
    }

}
