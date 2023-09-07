package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class RadioButtonsPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css="input[value='Male'][name='optradio']")
    WebElement maleButton;

    @FindBy(css="input[value='Female'][name='optradio']")
    WebElement femaleButton;

    @FindBy(xpath=("(//button[@class='btn btn-default'])[1]"))
    WebElement checkedValueButton;

    public RadioButtonsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickMaleButton() {
        WaitForElement.waitUntilElementIsVisible(maleButton);
        maleButton.click();
        logger.info("Click on Male button");
    }

    public void clickFemaleButton() {
        WaitForElement.waitUntilElementIsVisible(femaleButton);
        femaleButton.click();
        logger.info("Click on Female button");
    }

    public void clickCheckedValueButton() {
        WaitForElement.waitUntilElementIsVisible(checkedValueButton);
        checkedValueButton.click();
        logger.info("Click on Get Checked value button");
    }

    public String getCheckedValueButtonText() {
        WaitForElement.waitUntilElementIsVisible(checkedValueButton);
        return checkedValueButton.getText();
    }
}
