package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MyAccountPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(css="[class='page-title']")
    WebElement pageTitle;

    @FindBy(xpath="//div[contains(@class, 'listbox')]//a[text()='Addresses']")
    WebElement addressesButton;

    public MyAccountPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void clickAddressesButton() {
        WaitForElement.waitUntilElementIsClickable(addressesButton);
        addressesButton.click();
        logger.info("Kliknięto przycisk Addresses");
    }

}
