package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.BootstrapAlertsPage;
import page.objects.LandingPage;
import waits.OtherWaits;

import static navigation.ApplicationURLs.BOOTSTRAP_ALERT_URL;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BootstrapAlertTests extends TestBase {

    @Test
    public void checkAutocloseableMessage() {
        DriverUtils.navigateToPage(BOOTSTRAP_ALERT_URL);
        BootstrapAlertsPage bootstrapAlertsPage = new BootstrapAlertsPage();
        assertFalse(bootstrapAlertsPage.isAutocloseableMessageDisplayed());
        bootstrapAlertsPage.clickAutocloseableButtonMessage();
        assertTrue(bootstrapAlertsPage.isAutocloseableMessageDisplayed());
        OtherWaits.waitForXSeconds("7");
        assertFalse(bootstrapAlertsPage.isAutocloseableMessageDisplayed());
    }
}