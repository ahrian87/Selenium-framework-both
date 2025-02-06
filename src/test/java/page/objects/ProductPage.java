package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import waits.WaitForElement;

public class ProductPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(css="[class='button-2 add-to-wishlist-button']")
    WebElement addToWishlistButton;

    @FindBy(css="[class='button-1 add-to-cart-button']")
    WebElement addToCartButton;

    public ProductPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickAddToWishlistButton() {
        WaitForElement.waitUntilElementIsClickable(addToWishlistButton);
        addToWishlistButton.click();
        logger.info("Kliknięto przycisk Add to wishlist");
    }

    public void clickAddToCartButton() {
        WaitForElement.waitUntilElementIsClickable(addToCartButton);
        addToCartButton.click();
        logger.info("Kliknięto przycisk Add to cart");
    }
}
