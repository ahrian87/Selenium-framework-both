package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AddressesPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(css="[class='add-button']")
    WebElement addNewAddressButton;

    @FindBy(css="[id='Address_FirstName']")
    WebElement firstNameField;

    @FindBy(css="[id='Address_LastName']")
    WebElement lastNameField;

    @FindBy(css="[id='Address_Email']")
    WebElement emailField;

    @FindBy(css="[id='Address_CountryId']")
    WebElement countrySelect;

    @FindBy(css="[id='Address_City']")
    WebElement cityField;

    @FindBy(css="[id='Address_Address1']")
    WebElement addressOneField;

    @FindBy(css="[id='Address_ZipPostalCode']")
    WebElement zipCodeField;

    @FindBy(css="[id='Address_PhoneNumber']")
    WebElement phoneNumberField;

    public AddressesPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public void clickAddNewAddressButton() {
        WaitForElement.waitUntilElementIsClickable(addNewAddressButton);
        addNewAddressButton.click();
        logger.info("Kliknięto przycisk Add new");
    }
}
