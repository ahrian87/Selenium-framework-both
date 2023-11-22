package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:")
        }
    }
}
