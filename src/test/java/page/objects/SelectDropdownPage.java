package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tests.TestBase;
import waits.WaitForElement;

public class SelectDropdownPage extends TestBase {

    private Logger logger = LogManager.getRootLogger();

    Select selectDaySelect;
    Select selectStateSelect;

    @FindBy(css = ".form-control")
    WebElement selectDayDropdown;

    @FindBy(xpath = "//select[@name='States']")
    WebElement selectStateList;

    @FindBy(xpath = "//button[@id='printMe']")
    WebElement firstSelectedButton;

    @FindBy(css = "p.getall-selected")
    WebElement selectStateMessage;

    public SelectDropdownPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
        selectDaySelect = new Select(selectDayDropdown);
        selectStateSelect = new Select(selectStateList);
    }

    public void selectDayByVisibleText(String day) {
        selectDaySelect.selectByVisibleText(day);
        logger.info("Select chosen day - " + day);
    }

    public String getSelectedOptionValue() {
        logger.info("Get selected option value");
        return selectDaySelect.getFirstSelectedOption().getText();
    }

    public void selectOneState(String state) {
        selectStateSelect.selectByVisibleText(state);
        logger.info("Select one state - " + state);
        WaitForElement.waitUntilElementIsVisible(firstSelectedButton);
        firstSelectedButton.click();
        logger.info("Click First Selected button");
    }

    public String getSelectedStateMessageValue() {
        logger.info("Get selected state message value");
        return selectStateMessage.getText();
    }
}
