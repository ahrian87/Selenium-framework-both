package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.LandingPage;
import page.objects.RadioButtonsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class RadioButtonTests extends TestBase {

    @Test
    public void getCheckedValueWithoutAnyButtonsTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickRadioButtonsDemoButton();

        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage.clickCheckedValueButton();

        assertFalse(radioButtonsPage.isMaleButtonSelected());
        assertFalse(radioButtonsPage.isFemaleButtonSelected());

        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button is Not checked");
    }

    @Test
    public void selectingMaleButton() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickRadioButtonsDemoButton();

        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage.clickMaleButton();

        assertTrue(radioButtonsPage.isMaleButtonSelected());

        radioButtonsPage.clickCheckedValueButton();
        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button 'Male' is checked");
    }

    @Test
    public void selectingFemaleButton() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickRadioButtonsDemoButton();

        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage.clickFemaleButton();

        assertTrue(radioButtonsPage.isFemaleButtonSelected());

        radioButtonsPage.clickCheckedValueButton();
        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button 'Female' is checked");
    }

    @Test
    public void groupButtonsNoSelectionTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickRadioButtonsDemoButton();

        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage.clickGetValuesButton();

        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex :\n" +
                "Age group:");
    }
}
