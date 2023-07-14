package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {

    @FindBy(css="input[type='checkbox'][id='isAgeSelected']")
    WebElement firstCheckbox;

    @FindBy(css="div[id='txtAge']")
    WebElement successMessageBlock;

    private WebDriver driver;

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFirstCheckbox() {
        firstCheckbox.click();
    }

    public boolean isSuccessMessageDisplayed() {
        boolean isDisplayed = successMessageBlock.isDisplayed();
        return isDisplayed;
    }
}
