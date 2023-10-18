package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage {

    private Logger logger = LogManager.getRootLogger();

    public JavaScriptAlertsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
