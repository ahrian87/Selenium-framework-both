package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.JavaScriptAlertsPage;
import waits.OtherWaits;

import static navigation.ApplicationURLs.JAVASCRIPT_ALERT_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptAlertsTests extends TestBase {

    @Test
    public void closeAlertBoxTest() {
        DriverUtils.navigateToPage(JAVASCRIPT_ALERT_URL);
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptAlertsPage
                .clickJavaScriptAlertBoxButton();
        assertTrue(javaScriptAlertsPage.isAlertVisible());
        javaScriptAlertsPage.closeAlertBox();
    }

    @Test
    public void closeConfirmBoxWithOk() {
        DriverUtils.navigateToPage(JAVASCRIPT_ALERT_URL);
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptAlertsPage
                .clickJavaScriptConfirmBoxButton();
        assertTrue(javaScriptAlertsPage.isAlertVisible());
        javaScriptAlertsPage.closeAlertBox();
        assertEquals(javaScriptAlertsPage.getConfirmationMessage(), "You pressed OK!");
    }

    @Test
    public void closeConfirmBoxWithCancel() {
        DriverUtils.navigateToPage(JAVASCRIPT_ALERT_URL);
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptAlertsPage
                .clickJavaScriptConfirmBoxButton();
        assertTrue(javaScriptAlertsPage.isAlertVisible());
        javaScriptAlertsPage.dismissAlertBox();
        assertEquals(javaScriptAlertsPage.getConfirmationMessage(), "You pressed Cancel!");
    }

    @Test
    public void closePromptBoxWithText() {
        DriverUtils.navigateToPage(JAVASCRIPT_ALERT_URL);
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptAlertsPage
                .clickJavaScriptPromptBoxButton();
        assertTrue(javaScriptAlertsPage.isAlertVisible());
        javaScriptAlertsPage.sendKeysToPromptBox("test message");
        OtherWaits.waitForXSeconds("3");
        javaScriptAlertsPage.closeAlertBox();
        assertEquals(javaScriptAlertsPage.getPromptBoxMessage(), "You have entered 'test message' !");
    }
}