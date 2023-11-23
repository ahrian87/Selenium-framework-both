package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.RadioButtonsPage;

import static navigation.ApplicationURLs.RADIO_BUTTONS_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class RadioButtonTests extends TestBase {

    @Test
    public void getCheckedValueWithoutAnyButtonsTest() {
        DriverUtils.navigateToPage(RADIO_BUTTONS_URL);
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage
                .clickCheckedValueButton();
        assertFalse(radioButtonsPage.isMaleButtonSelected());
        assertFalse(radioButtonsPage.isFemaleButtonSelected());
        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button is Not checked");
    }

    @Test
    public void selectingMaleButtonTest() {
        DriverUtils.navigateToPage(RADIO_BUTTONS_URL);
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage
                .clickMaleButton();
        assertTrue(radioButtonsPage.isMaleButtonSelected());

        radioButtonsPage.clickCheckedValueButton();
        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button 'Male' is checked");
    }

    @Test
    public void selectingFemaleButtonTest() {
        DriverUtils.navigateToPage(RADIO_BUTTONS_URL);
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage
                .clickFemaleButton();
        assertTrue(radioButtonsPage.isFemaleButtonSelected());

        radioButtonsPage.clickCheckedValueButton();
        assertEquals(radioButtonsPage.getRadioButtonMessageText(), "Radio button 'Female' is checked");
    }

    @Test
    public void groupButtonsNoSelectionTest() {
        DriverUtils.navigateToPage(RADIO_BUTTONS_URL);
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage
                .clickGetValuesButton();
        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex :\n" +
                "Age group:");
    }

    @Test
    public void groupButtonsMaleButtonSelectedTest() {
        DriverUtils.navigateToPage(RADIO_BUTTONS_URL);
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage
                .clickMaleGroupButton()
                .clickGetValuesButton();
        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex : Male\n" +
                "Age group:");
    }

    @Test
    public void groupButtonsFemaleButtonSelectedTest() {
        DriverUtils.navigateToPage(RADIO_BUTTONS_URL);
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage
                .clickFemaleGroupButton()
                .clickGetValuesButton();
        assertEquals(radioButtonsPage.getGroupRadioButtonMessageText(), "Sex : Female\n" +
                "Age group:");
    }

    @Test
    public void genderAndAgeSelectedTest() {
        DriverUtils.navigateToPage(RADIO_BUTTONS_URL);
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage();
        radioButtonsPage
                .clickMaleGroupButton()
                .clickFirstAgeGroupButton()
                .clickGetValuesButton();
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