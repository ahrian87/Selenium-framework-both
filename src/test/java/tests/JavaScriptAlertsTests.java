package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.JavaScriptAlertsPage;
import page.objects.LandingPage;
import page.objects.RadioButtonsPage;

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
}
