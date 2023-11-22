package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {

    private Logger logger = LogManager.getRootLogger();
    @FindBy(css="#btn_basic_example")
    WebElement startButton;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public BasicExamplesPage clickOnStartButton() {
        WaitForElement.waitUntilElementIsClickable(startButton);
        startButton.click();
        logger.info("Clicked on Enter Store link");
        return new BasicExamplesPage();
    }
}