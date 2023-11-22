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

    @FindBy(xpath=("(//button[@class='btn btn-default'])[2]"))
    WebElement getValuesButton;

    @FindBy(xpath=("//p[@class='radiobutton']"))
    WebElement radioButtonMessage;

    @FindBy(css="p.groupradiobutton")
    WebElement groupRadioButtonTextField;

    @FindBy(css="input[value='Male'][name='gender']")
    WebElement maleGroupButton;

    @FindBy(css="input[value='Female'][name='gender']")
    WebElement femaleGroupButton;

    @FindBy(css="input[value='0 - 5'][name='ageGroup']")
    WebElement firstAgeGroup;

    @FindBy(css="input[value='5 - 15'][name='ageGroup']")
    WebElement secondAgeGroup;

    @FindBy(css="input[value='15 - 50'][name='ageGroup']")
    WebElement thirdAgeGroup;

    public RadioButtonsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public RadioButtonsPage clickMaleButton() {
        WaitForElement.waitUntilElementIsVisible(maleButton);
        maleButton.click();
        logger.info("Click on Male button");
        return this;
    }

    public RadioButtonsPage clickFemaleButton() {
        WaitForElement.waitUntilElementIsVisible(femaleButton);
        femaleButton.click();
        logger.info("Click on Female button");
        return this;
    }

    public RadioButtonsPage clickCheckedValueButton() {
        WaitForElement.waitUntilElementIsVisible(checkedValueButton);
        checkedValueButton.click();
        logger.info("Click on Get Checked value button");
        return this;
    }

    public RadioButtonsPage clickGetValuesButton() {
        WaitForElement.waitUntilElementIsClickable(getValuesButton);
        getValuesButton.click();
        logger.info("Click on Get values button");
        return this;
    }

    public String getRadioButtonMessageText() {
        WaitForElement.waitUntilElementIsVisible(radioButtonMessage);
        logger.info("Checked radio button message text");
        return radioButtonMessage.getText();
    }

    public String getGroupRadioButtonMessageText() {
        WaitForElement.waitUntilElementIsVisible(groupRadioButtonTextField);
        logger.info("Checked group radio button message text");
        return groupRadioButtonTextField.getText();
    }

    public RadioButtonsPage clickMaleGroupButton() {
        WaitForElement.waitUntilElementIsClickable(maleGroupButton);
        maleGroupButton.click();
        logger.info("Click on Male button in group radio buttons section");
        return this;
    }

    public RadioButtonsPage clickFemaleGroupButton() {
        WaitForElement.waitUntilElementIsClickable(femaleGroupButton);
        femaleGroupButton.click();
        logger.info("Click on Female button in group radio buttons section");
        return this;
    }

    public RadioButtonsPage clickFirstAgeGroupButton() {
        WaitForElement.waitUntilElementIsClickable(firstAgeGroup);
        firstAgeGroup.click();
        logger.info("Click on first age group button");
        return this;
    }

    public RadioButtonsPage clickSecondAgeGroupButton() {
        WaitForElement.waitUntilElementIsClickable(firstAgeGroup);
        secondAgeGroup.click();
        logger.info("Click on second age group button");
        return this;
    }

    public RadioButtonsPage clickThirdAgeGroupButton() {
        WaitForElement.waitUntilElementIsClickable(firstAgeGroup);
        thirdAgeGroup.click();
        logger.info("Click on third age group button");
        return this;
    }

    public boolean isMaleButtonSelected() {
        return maleButton.isSelected();
    }

    public boolean isFemaleButtonSelected() {
        return femaleButton.isSelected();
    }
}