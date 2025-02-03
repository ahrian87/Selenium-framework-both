package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryBarPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="(//ul[contains(@class, 'top-menu')]//a[contains(@href, '/books')])[1]")
    WebElement booksCategoryBarButton;

    @FindBy(xpath="(//ul[contains(@class, 'top-menu')]//a[contains(@href, '/computers')])[1]")
    WebElement computersCategoryBarButton;

    @FindBy(xpath="(//ul[contains(@class, 'top-menu')]//a[contains(@href, '/electronics')])[1]")
    WebElement electronicsCategoryBarButton;

    @FindBy(xpath="(//ul[contains(@class, 'top-menu')]//a[contains(@href, '/apparel-shoes')])[1]")
    WebElement apparelAndShoesCategoryBarButton;

    @FindBy(xpath="(//ul[contains(@class, 'top-menu')]//a[contains(@href, '/digital-downloads')])[1]")
    WebElement digitalDownloadsCategoryBarButton;

    @FindBy(xpath="(//a[contains(text(), 'Jewelry')])[1]")
    WebElement jewelryCategoryBarButton;

    @FindBy(xpath="(//a[contains(text(), 'Gift Cards')])[1]")
    WebElement giftCardsCategoryBarButton;


    public CategoryBarPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
