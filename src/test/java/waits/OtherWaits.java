package waits;

import driver.manager.DriverManager;
import org.openqa.selenium.Alert;

public class OtherWaits {

    public static void waitForXSeconds(String x) {
        try {
            Thread.sleep(Integer.parseInt(x) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}