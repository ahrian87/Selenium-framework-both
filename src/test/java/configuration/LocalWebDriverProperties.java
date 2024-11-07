package configuration;

import driver.BrowserType;

public class LocalWebDriverProperties {
    public static BrowserType getLocalBrowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("local.browser"));
    }
}
