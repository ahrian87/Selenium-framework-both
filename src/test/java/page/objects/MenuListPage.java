package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MenuListPage {
    private Logger logger = LogManager.getRootLogger();
    @FindBy(xpath="//ul[@id='treemenu']//a[contains(text(), 'Input Forms')]")
    WebElement inputFormsLink;

    public MenuListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnInputFormsLink() {
        WaitForElement.waitUntilElementIsClickable(inputFormsLink);
        inputFormsLink.click();
        logger.info("Clicked on input forms link");
    }

}
