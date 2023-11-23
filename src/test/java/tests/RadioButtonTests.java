package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.RadioButtonsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class RadioButtonTests extends TestBase {

    @Test
    public void getCheckedValueWithoutAnyButtonsTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickRadioButtonsDemoButton()
                .clickCheckedValueButton();
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        assertFalse(radioButtonsPage.isMaleButtonSelected());
        assertFalse(radioButtonsPage.isFemaleButtonSelected());
        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button is Not checked");
    }

    @Test
    public void selectingMaleButtonTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickRadioButtonsDemoButton()
                .clickMaleButton();
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        assertTrue(radioButtonsPage.isMaleButtonSelected());

        radioButtonsPage.clickCheckedValueButton();
        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button 'Male' is checked");
    }

    @Test
    public void selectingFemaleButtonTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickRadioButtonsDemoButton()
                .clickFemaleButton();
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        assertTrue(radioButtonsPage.isFemaleButtonSelected());

        radioButtonsPage.clickCheckedValueButton();
        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button 'Female' is checked");
    }

    @Test
    public void groupButtonsNoSelectionTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickRadioButtonsDemoButton()
                .clickGetValuesButton();
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex :\n" +
                "Age group:");
    }

    @Test
    public void groupButtonsMaleButtonSelectedTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickRadioButtonsDemoButton()
                .clickMaleGroupButton()
                .clickGetValuesButton();
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex : Male\n" +
                "Age group:");
    }

    @Test
    public void groupButtonsFemaleButtonSelectedTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickRadioButtonsDemoButton()
                .clickFemaleGroupButton()
                .clickGetValuesButton();
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex : Female\n" +
                "Age group:");
    }

    @Test
    public void genderAndAgeSelectedTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickRadioButtonsDemoButton()
                .clickMaleGroupButton()
                .clickFirstAgeGroupButton()
                .clickGetValuesButton();
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex : Male\n" +
                "Age group: 0 - 5");

        radioButtonsPage
                .clickFemaleGroupButton()
                .clickSecondAgeGroupButton()
                .clickGetValuesButton();

        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex : Female\n" +
                "Age group: 5 - 15");

        radioButtonsPage
                .clickFemaleGroupButton()
                .clickThirdAgeGroupButton()
                .clickGetValuesButton();

        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex : Female\n" +
                "Age group: 15 - 50");
    }
}