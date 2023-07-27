package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.CheckboxPage;
import page.objects.LandingPage;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

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
}
