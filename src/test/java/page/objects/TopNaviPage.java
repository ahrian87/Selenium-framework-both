package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopNaviPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css="[alt='Tricentis Demo Web Shop']")
    WebElement shopLogo;

    @FindBy(css="[class='ico-register']")
    WebElement registerButton;

    @FindBy(css="[class='ico-login']")
    WebElement loginButton;

    @FindBy(css="[id='topcartlink']")
    WebElement cartButton;

    @FindBy(css="[class='ico-wishlist]")
    WebElement wishlistButton;

    @FindBy(css="[name='q']")
    WebElement searchField;

    @FindBy(css="[class='button-1 search-box-button']")
    WebElement searchButton;

    @FindBy(css="[class='ico-logout']")
    WebElement logoutButton;

    @FindBy(xpath="//div[contains(@class, 'header-links')]//a[contains(@class, 'account')]")
    WebElement accountName;

    public TopNaviPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickRegisterButton() {
        WaitForElement.waitUntilElementIsClickable(registerButton);
        registerButton.click();
        logger.info("Kliknięto przycisk Register");
    }

    public void clickLoginButton() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Kliknięto przycisk Login");
    }

    public void clickCartButton() {
        WaitForElement.waitUntilElementIsClickable(cartButton);
        cartButton.click();
        logger.info("Kliknięto przycisk Shopping cart");
    }

    public void clickWishlistButton() {
        WaitForElement.waitUntilElementIsClickable(wishlistButton);
        wishlistButton.click();
        logger.info("Kliknięto przycisk Wishlist");
    }

    public void clickShopLogo() {
        WaitForElement.waitUntilElementIsClickable(shopLogo);
        shopLogo.click();
        logger.info("Kliknięto logo strony");
    }

    public void clickLogOutButton() {
        WaitForElement.waitUntilElementIsVisible(logoutButton);
        WaitForElement.waitUntilElementIsClickable(logoutButton);
        logoutButton.click();
        logger.info("Kliknięto przycisk Logout");
    }

    public boolean isAccountLoginVisible() {
        return accountName.isDisplayed();
    }
}
