package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.JavaScriptAlertsPage;
import page.objects.LandingPage;
import waits.OtherWaits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptAlertsTests extends TestBase {

    @Test
    public void closeAlertBoxTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickJavascriptAlertsButton();

        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptAlertsPage.clickJavaScriptAlertBoxButton();

        assertTrue(javaScriptAlertsPage.isAlertVisible());

        javaScriptAlertsPage.closeAlertBox();
    }

    @Test
    public void closeConfirmBoxWithOk() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickJavascriptAlertsButton();

        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptAlertsPage.clickJavaScriptConfirmBoxButton();

        assertTrue(javaScriptAlertsPage.isAlertVisible());

        javaScriptAlertsPage.closeAlertBox();

        assertEquals(javaScriptAlertsPage.getConfirmationMessage(), "You pressed OK!");
    }

    @Test
    public void closeConfirmBoxWithCancel() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickJavascriptAlertsButton();

        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptAlertsPage.clickJavaScriptConfirmBoxButton();

        assertTrue(javaScriptAlertsPage.isAlertVisible());

        javaScriptAlertsPage.dismissAlertBox();

        assertEquals(javaScriptAlertsPage.getConfirmationMessage(), "You pressed Cancel!");
    }

    @Test
    public void closePromptBoxWithText() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickJavascriptAlertsButton();

        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptAlertsPage.clickJavaScriptPromptBoxButton();

        assertTrue(javaScriptAlertsPage.isAlertVisible());

        javaScriptAlertsPage.sendKeysToPromptBox("test message");

        try {
            OtherWaits.waitForXSeconds("3");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        javaScriptAlertsPage.closeAlertBox();

        assertEquals(javaScriptAlertsPage.getPromptBoxMessage(), "You have entered 'test message' !");
    }

}
