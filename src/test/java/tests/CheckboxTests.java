package tests;

import org.testng.annotations.Test;
import page.objects.CheckboxPage;
import page.objects.LandingPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class CheckboxTests extends TestBase {

    @Test
    public void singleCheckboxTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickCheckBoxDemoButton()
                .clickOnFirstCheckbox();
        CheckboxPage checkboxPage = new CheckboxPage();
        assertTrue(checkboxPage.isSuccessMessageDisplayed());
        assertTrue(checkboxPage.isFirstCheckboxSelected());
        assertTrue(checkboxPage.isSecondCheckboxSelected());
    }

    @Test
    public void twoCheckboxesTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickCheckBoxDemoButton()
                .clickOnFirstCheckbox()
                .clickOnSecondCheckbox();
        CheckboxPage checkboxPage = new CheckboxPage();
        assertTrue(checkboxPage.isSuccessMessageDisplayed());
        assertTrue(checkboxPage.isFirstCheckboxSelected());
        assertFalse(checkboxPage.isSecondCheckboxSelected());
    }

    @Test
    public void checkAllOptionBoxesTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickCheckBoxDemoButton()
                .clickOnFirstOptionCheckbox()
                .clickOnSecondOptionCheckbox()
                .clickOnThirdOptionCheckbox()
                .clickOnFourthOptionCheckbox();
        CheckboxPage checkboxPage = new CheckboxPage();
        assertTrue(checkboxPage.isFirstOptionCheckboxSelected());
        assertTrue(checkboxPage.isSecondOptionCheckboxSelected());
        assertTrue(checkboxPage.isThirdOptionCheckboxSelected());
        assertTrue(checkboxPage.isFourthOptionCheckboxSelected());
        assertEquals(checkboxPage.getCheckAllButtonText(), "Uncheck All");
    }

    @Test
    public void checkAllOptionBoxesWithCheckAllButtonTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickCheckBoxDemoButton();
        CheckboxPage checkboxPage = new CheckboxPage();
        assertEquals(checkboxPage.getCheckAllButtonText(), "Check All");
        assertFalse(checkboxPage.isFirstOptionCheckboxSelected());
        assertFalse(checkboxPage.isSecondOptionCheckboxSelected());
        assertFalse(checkboxPage.isThirdOptionCheckboxSelected());
        assertFalse(checkboxPage.isFourthOptionCheckboxSelected());

        checkboxPage.clickOnCheckAllButton();

        assertTrue(checkboxPage.isFirstOptionCheckboxSelected());
        assertTrue(checkboxPage.isSecondOptionCheckboxSelected());
        assertTrue(checkboxPage.isThirdOptionCheckboxSelected());
        assertTrue(checkboxPage.isFourthOptionCheckboxSelected());
        assertEquals(checkboxPage.getCheckAllButtonText(), "Uncheck All");
    }

    @Test
    public void checkAllAndUncheckAllWithButtonsTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickCheckBoxDemoButton();
        CheckboxPage checkboxPage = new CheckboxPage();
        assertEquals(checkboxPage.getCheckAllButtonText(), "Check All");

        checkboxPage.clickOnCheckAllButton();
        assertTrue(checkboxPage.isFirstOptionCheckboxSelected());
        assertTrue(checkboxPage.isSecondOptionCheckboxSelected());
        assertTrue(checkboxPage.isThirdOptionCheckboxSelected());
        assertTrue(checkboxPage.isFourthOptionCheckboxSelected());
        assertEquals(checkboxPage.getCheckAllButtonText(), "Uncheck All");

        checkboxPage.clickOnCheckAllButton();
        assertFalse(checkboxPage.isFirstOptionCheckboxSelected());
        assertFalse(checkboxPage.isSecondOptionCheckboxSelected());
        assertFalse(checkboxPage.isThirdOptionCheckboxSelected());
        assertFalse(checkboxPage.isFourthOptionCheckboxSelected());
        assertEquals(checkboxPage.getCheckAllButtonText(), "Check All");
    }
}