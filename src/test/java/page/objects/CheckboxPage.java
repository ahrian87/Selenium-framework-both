package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class CheckboxPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css="input[type='checkbox'][id='isAgeSelected']")
    WebElement firstCheckbox;

    @FindBy(css="div[id='txtAge']")
    WebElement successMessageBlock;

    @FindBy(xpath="(//div[@class='checkbox']//input[@type='checkbox'])[2]")
    WebElement secondCheckbox;

    @FindBy(css="input[class='cb1-element']:first-child")
    WebElement firstOptionCheckbox;

    @FindBy(xpath="(//input[@class='cb1-element'])[2]")
    WebElement secondOptionCheckbox;

    @FindBy(xpath="(//input[@class='cb1-element'])[3]")
    WebElement thirdOptionCheckbox;

    @FindBy(xpath="(//input[@class='cb1-element'])[4]")
    WebElement fourthOptionCheckbox;

    @FindBy(xpath="//input[@id='check1']")
    WebElement checkAllButton;

    public CheckboxPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnFirstCheckbox() {
        WaitForElement.waitUntilElementIsClickable(firstCheckbox);
        firstCheckbox.click();
        logger.info("Clicked on first checkbox");
    }

    public void clickOnSecondCheckbox() {
        WaitForElement.waitUntilElementIsClickable(secondCheckbox);
        secondCheckbox.click();
        logger.info("Clicked on second checkbox");
    }

    public void clickOnFirstOptionCheckbox() {
        WaitForElement.waitUntilElementIsClickable(firstOptionCheckbox);
        firstOptionCheckbox.click();
        logger.info("Clicked on Option 1 checkbox");
    }

    public void clickOnSecondOptionCheckbox() {
        WaitForElement.waitUntilElementIsClickable(secondOptionCheckbox);
        secondOptionCheckbox.click();
        logger.info("Clicked on Option 2 checkbox");
    }

    public void clickOnThirdOptionCheckbox() {
        WaitForElement.waitUntilElementIsClickable(thirdOptionCheckbox);
        thirdOptionCheckbox.click();
        logger.info("Clicked on Option 3 checkbox");
    }

    public void clickOnFourthOptionCheckbox() {
        WaitForElement.waitUntilElementIsClickable(fourthOptionCheckbox);
        fourthOptionCheckbox.click();
        logger.info("Clicked on Option 4 checkbox");
    }

    public void clickOnCheckAllButton() {
        WaitForElement.waitUntilElementIsClickable(checkAllButton);
        checkAllButton.click();
        logger.info("Clicked on Check All button");
    }

    public boolean isSuccessMessageDisplayed() {
        logger.info("Success message is displayed");
        return successMessageBlock.isDisplayed();
    }

    public boolean isFirstCheckboxSelected() {
        return firstCheckbox.isSelected();
    }

    public boolean isSecondCheckboxSelected() {
        return secondCheckbox.isSelected();
    }

    public boolean isFirstOptionCheckboxSelected() {
        return firstOptionCheckbox.isSelected();
    }

    public boolean isSecondOptionCheckboxSelected() {
        return secondOptionCheckbox.isSelected();
    }

    public boolean isThirdOptionCheckboxSelected() {
        return thirdOptionCheckbox.isSelected();
    }

    public boolean isFourthOptionCheckboxSelected() {
        return fourthOptionCheckbox.isSelected();
    }

    public String getCheckAllButtonText() {
        WaitForElement.waitUntilElementIsVisible(checkAllButton);
        return checkAllButton.getAttribute("value");
    }
}