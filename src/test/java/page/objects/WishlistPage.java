package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class WishlistPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(css="[class='page-title']")
    WebElement pageTitle;

    @FindBy(css="[name='removefromcart']")
    WebElement removeFromCartCheckbox;

    @FindBy(css="[name='updatecart']")
    WebElement updateCartButton;

    @FindBy(css="[class='wishlist-content']")
    WebElement wishlistContentMessage;

    public WishlistPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getPagetitle(){
        return pageTitle.getText();
    }

    public boolean isRemoveCheckboxVisible() {
        WaitForElement.waitUntilElementIsVisible(pageTitle);
        return removeFromCartCheckbox.isDisplayed();
    }

    public void clickRemoveFromCartCheckbox() {
        WaitForElement.waitUntilElementIsVisible(removeFromCartCheckbox);
        removeFromCartCheckbox.click();
        logger.info("Zaznaczono checkbox Remove");
    }

    public void clickUpdateCartButton() {
        WaitForElement.waitUntilElementIsClickable(updateCartButton);
        updateCartButton.click();
        logger.info("Kliknięto przycisk Update cart");
    }

    public String getWishlistContentMessage() {
        WaitForElement.waitUntilElementIsVisible(wishlistContentMessage);
        return wishlistContentMessage.getText();
    }
}
