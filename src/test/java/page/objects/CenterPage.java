package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class CenterPage {

    private static final Logger logger = LogManager.getRootLogger();

    public CenterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
