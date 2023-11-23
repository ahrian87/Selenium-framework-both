package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.SelectDropdownPage;

import static org.testng.Assert.assertEquals;

public class SelectDropdownTests extends TestBase {

    @Test
    public void selectDayTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickSelectDropdownListButton()
                .selectDayByVisibleText("Monday");
        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        assertEquals(selectDropdownPage.getSelectedOptionValue(), "Monday");
    }

    @Test
    public void selectOneStateTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickSelectDropdownListButton()
                .selectState("Ohio")
                .clickFirstSelectedButton();
        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        assertEquals(selectDropdownPage.getSelectedStateMessageValue(), "First selected option is : Ohio");
    }

    @Test
    public void selectMultipleStatesTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickSelectDropdownListButton()
                .selectState("Ohio")
                .selectState("Texas")
                .selectState("Washington");
        // do poprawy - średnia walidacja
        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        selectDropdownPage.clickGetAllSelectedButton();
        assertEquals(selectDropdownPage.getSelectedStateMessageValue(), "Options selected are : Washington");
    }
}