package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {

    @FindBy(css="input[type='checkbox'][id='isAgeSelected']")
    WebElement firstCheckbox;

    @FindBy(css="div[id='txtAge']")
    WebElement successMessageBlock;


    public CheckboxPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnFirstCheckbox() {
        firstCheckbox.click();
    }

    public boolean isSuccessMessageDisplayed() {
        boolean isDisplayed = successMessageBlock.isDisplayed();
        return isDisplayed;
    }
}
