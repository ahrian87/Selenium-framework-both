package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.LandingPage;
import page.objects.SelectDropdownPage;

import static org.testng.Assert.assertEquals;

public class SelectDropdownTests extends TestBase {

    @Test
    public void selectDayTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickSelectDropdownListButton();

        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        selectDropdownPage.selectDayByVisibleText("Monday");

        assertEquals(selectDropdownPage.getSelectedOptionValue(), "Monday");
    }

    @Test
    public void selectOneStateTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickSelectDropdownListButton();

        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        selectDropdownPage.selectOneState("Ohio");

        assertEquals(selectDropdownPage.getSelectedStateMessageValue(), "First selected option is : Ohio");
    }
}
