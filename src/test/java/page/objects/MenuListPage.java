package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuListPage {
    @FindBy(xpath="//ul[@id='treemenu']//a[contains(text(), 'Input Forms')]")
    WebElement inputFormsLink;

    public MenuListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnInputFormsLink() {
        inputFormsLink.click();
    }

}
