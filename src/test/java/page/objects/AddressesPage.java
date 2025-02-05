package page.objects;

import driver.manager.DriverManager;
import functions.FakeDataGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    public void fillFirstNameField(String firstName) {
        WaitForElement.waitUntilElementIsClickable(firstNameField);
        firstNameField.sendKeys(firstName);
        logger.info("Uzupełniono pole First Name: {}", firstName);
    }

    public void fillLastNameField(String lastName) {
        WaitForElement.waitUntilElementIsClickable(lastNameField);
        lastNameField.sendKeys(lastName);
        logger.info("Uzupełniono pole Last Name: {}", lastName);
    }

    public void fillEmailFieldWithRandomValue() {
        WaitForElement.waitUntilElementIsClickable(emailField);
        String email = FakeDataGenerator.generateFakeEmail();
        emailField.sendKeys(email);
        logger.info("Uzupełniono pole Email: {}", email);
    }

    public void selectCountry() {
        WaitForElement.waitUntilElementIsVisible(countrySelect);
        Select countryDropDown = new Select(countrySelect);
        countryDropDown.selectByVisibleText("Poland");
        logger.info("Wybrano kraj: Polska");
    }

    public void fillCityField(String cityName) {
        WaitForElement.waitUntilElementIsClickable(cityField);
        cityField.sendKeys(cityName);
        logger.info("Uzupełniono pole City Name: {}", cityName);
    }

    public void fillAddressOneField(String addressOne) {
        WaitForElement.waitUntilElementIsClickable(addressOneField);
        addressOneField.sendKeys(addressOne);
        logger.info("Uzupełniono pole Address 1: {}", addressOne);
    }

    public void fillZipCodeField(String zipCode) {
        WaitForElement.waitUntilElementIsClickable(zipCodeField);
        zipCodeField.sendKeys(zipCode);
        logger.info("Uzupełniono pole Zipcode: {}", zipCode);
    }

    public void fillPhoneNumberFieldWithRandomValue() {
        WaitForElement.waitUntilElementIsClickable(phoneNumberField);
        String phone = FakeDataGenerator.generateFakePhoneNumber();
        phoneNumberField.sendKeys(phone);
        logger.info("Uzupełniono pole Phone number: {}", phone);
    }
}
