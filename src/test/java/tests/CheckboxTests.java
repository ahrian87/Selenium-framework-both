package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.CheckboxPage;
import page.objects.LandingPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CheckboxTests extends TestBase {

    @Test
    public void singleCheckboxTest() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnStartButton();


        BasicExamplesPage basicExamplesPage = new BasicExamplesPage(driver);
        basicExamplesPage.clickCheckBoxDemoButton();


        CheckboxPage checkboxPage = new CheckboxPage(driver);
        checkboxPage.clickOnFirstCheckbox();


        assertTrue(checkboxPage.isSuccessMessageDisplayed());
    }
}
