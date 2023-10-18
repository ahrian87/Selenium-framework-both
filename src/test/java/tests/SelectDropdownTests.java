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
        selectDropdownPage.selectState("Ohio");
        selectDropdownPage.clickFirstSelectedButton();

        assertEquals(selectDropdownPage.getSelectedStateMessageValue(), "First selected option is : Ohio");
    }

    @Test
    public void selectMultipleStatesTest() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStartButton();

        BasicExamplesPage basicExamplesPage = new BasicExamplesPage();
        basicExamplesPage.clickSelectDropdownListButton();

        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        selectDropdownPage.selectState("Ohio");
        selectDropdownPage.selectState("Texas");
        selectDropdownPage.selectState("Washington");

        selectDropdownPage.clickGetAllSelectedButton();
        assertEquals(selectDropdownPage.getSelectedStateMessageValue(), "Options selected are : Washington");
    }
}
