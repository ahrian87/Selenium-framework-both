package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.CheckboxPage;

import static navigation.ApplicationURLs.CHECKBOX_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class CheckboxTests extends TestBase {

    @Test
    public void singleCheckboxTest() {
        DriverUtils.navigateToPage(CHECKBOX_URL);
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage
                .clickOnFirstCheckbox();
        assertTrue(checkboxPage.isSuccessMessageDisplayed());
        assertTrue(checkboxPage.isFirstCheckboxSelected());
        assertTrue(checkboxPage.isSecondCheckboxSelected());
    }

    @Test
    public void twoCheckboxesTest() {
        DriverUtils.navigateToPage(CHECKBOX_URL);
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage
                .clickOnFirstCheckbox()
                .clickOnSecondCheckbox();
        assertTrue(checkboxPage.isSuccessMessageDisplayed());
        assertTrue(checkboxPage.isFirstCheckboxSelected());
        assertFalse(checkboxPage.isSecondCheckboxSelected());
    }

    @Test
    public void checkAllOptionBoxesTest() {
        DriverUtils.navigateToPage(CHECKBOX_URL);
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage
                .clickOnFirstOptionCheckbox()
                .clickOnSecondOptionCheckbox()
                .clickOnThirdOptionCheckbox()
                .clickOnFourthOptionCheckbox();
        assertTrue(checkboxPage.isFirstOptionCheckboxSelected());
        assertTrue(checkboxPage.isSecondOptionCheckboxSelected());
        assertTrue(checkboxPage.isThirdOptionCheckboxSelected());
        assertTrue(checkboxPage.isFourthOptionCheckboxSelected());
        assertEquals(checkboxPage.getCheckAllButtonText(), "Uncheck All");
    }

    @Test
    public void checkAllOptionBoxesWithCheckAllButtonTest() {
        DriverUtils.navigateToPage(CHECKBOX_URL);
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
        DriverUtils.navigateToPage(CHECKBOX_URL);
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