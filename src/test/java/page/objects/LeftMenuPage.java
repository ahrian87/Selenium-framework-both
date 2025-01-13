package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenuPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath="//ul[contains(@class, 'list')]//a[contains(@href, '/books')]")
    WebElement booksLeftMenuButton;

    @FindBy(xpath="//ul[contains(@class, 'list')]//a[contains(@href, '/computers')]")
    WebElement computersLeftMenuButton;

    @FindBy(xpath="//ul[contains(@class, 'list')]//a[contains(@href, '/electronics')]")
    WebElement electronicsLeftMenuButton;

    @FindBy(xpath="//ul[contains(@class, 'list')]//a[contains(@href, '/apparel-shoes')]")
    WebElement apparelAndShoesLeftMenuButton;

    @FindBy(xpath="//ul[contains(@class, 'list')]//a[contains(@href, '/digital-downloads')]")
    WebElement digitalDownloadsLeftMenuButton;

    @FindBy(xpath="//ul[contains(@class, 'list')]//a[contains(@href, '/jewelry')]")
    WebElement jewelryLeftMenuButton;

    @FindBy(xpath="//ul[contains(@class, 'list')]//a[contains(@href, '/gift-cards')]")
    WebElement giftCardsLeftMenuButton;

    @FindBy(xpath="//ul[contains(@class, 'list')]//a[contains(@href, '/tricentis')]")
    WebElement tricentisLeftMenuButton;

    @FindBy(xpath="//div[contains(@class, 'tags')]//a[contains(@href, '/producttag/all')]")
    WebElement viewAllTagsLeftMenuButton;

    public LeftMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
