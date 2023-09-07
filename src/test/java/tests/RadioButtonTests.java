package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.LandingPage;
import page.objects.RadioButtonsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class RadioButtonTests {

    @Test
    public void getCheckedValueWithoutAnyButtonsTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickRadioButtonsDemoButton();

        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage.clickCheckedValueButton();

        assertFalse
    }
}
