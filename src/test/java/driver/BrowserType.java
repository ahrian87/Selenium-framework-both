package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
