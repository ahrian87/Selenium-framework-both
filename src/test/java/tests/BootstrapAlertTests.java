package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.BootstrapAlertsPage;
import page.objects.LandingPage;
import waits.OtherWaits;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BootstrapAlertTests extends TestBase {

    @Test
    public void checkAutocloseableMessage() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickBootstrapAlertsButton();
        BootstrapAlertsPage bootstrapAlertsPage = new BootstrapAlertsPage();
        assertFalse(bootstrapAlertsPage.isAutocloseableMessageDisplayed());
        bootstrapAlertsPage.clickAutocloseableButtonMessage();
        assertTrue(bootstrapAlertsPage.isAutocloseableMessageDisplayed());
        OtherWaits.waitForXSeconds("7");
        assertFalse(bootstrapAlertsPage.isAutocloseableMessageDisplayed());
    }
}