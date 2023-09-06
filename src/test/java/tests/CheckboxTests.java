package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.CheckboxPage;
import page.objects.LandingPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class CheckboxTests extends TestBase {

    @Test
    public void singleCheckboxTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickCheckBoxDemoButton();

        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.clickOnFirstCheckbox();

        assertTrue(checkboxPage.isSuccessMessageDisplayed());
        assertTrue(checkboxPage.isFirstCheckboxSelected());
        assertTrue(checkboxPage.isSecondCheckboxSelected());
    }

    @Test
    public void twoCheckboxesTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickCheckBoxDemoButton();

        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.clickOnFirstCheckbox();
        checkboxPage.clickOnSecondCheckbox();

        assertTrue(checkboxPage.isSuccessMessageDisplayed());
        assertTrue(checkboxPage.isFirstCheckboxSelected());
        assertFalse(checkboxPage.isSecondCheckboxSelected());
    }

    @Test
    public void checkAllOptionBoxesTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickCheckBoxDemoButton();

        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.clickOnFirstOptionCheckbox();
        checkboxPage.clickOnSecondOptionCheckbox();
        checkboxPage.clickOnThirdOptionCheckbox();
        checkboxPage.clickOnFourthOptionCheckbox();

        assertTrue(checkboxPage.isFirstOptionCheckboxSelected());
        assertTrue(checkboxPage.isSecondOptionCheckboxSelected());
        assertTrue(checkboxPage.isThirdOptionCheckboxSelected());
        assertTrue(checkboxPage.isFourthOptionCheckboxSelected());


        assertEquals(checkboxPage.getCheckAllButtonText(), "Uncheck All");
    }

    @Test
    public void checkAllOptionBoxesWithCheckAllButtonTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickCheckBoxDemoButton();

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
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickCheckBoxDemoButton();

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
