package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.SelectDropdownPage;

import static navigation.ApplicationURLs.SELECT_DROPDOWN_URL;
import static org.testng.Assert.assertEquals;

public class SelectDropdownTests extends TestBase {

    @Test
    public void selectDayTest() {
        DriverUtils.navigateToPage(SELECT_DROPDOWN_URL);
        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        selectDropdownPage
                .selectDayByVisibleText("Monday");
        assertEquals(selectDropdownPage.getSelectedOptionValue(), "Monday");
    }

    @Test
    public void selectOneStateTest() {
        DriverUtils.navigateToPage(SELECT_DROPDOWN_URL);
        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        selectDropdownPage
                .selectState("Ohio")
                .clickFirstSelectedButton();
        assertEquals(selectDropdownPage.getSelectedStateMessageValue(), "First selected option is : Ohio");
    }

    @Test
    public void selectMultipleStatesTest() {
        DriverUtils.navigateToPage(SELECT_DROPDOWN_URL);
        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();
        selectDropdownPage
                .selectState("Ohio")
                .selectState("Texas")
                .selectState("Washington")
                .clickGetAllSelectedButton();
        // do poprawy - średnia walidacja
        assertEquals(selectDropdownPage.getSelectedStateMessageValue(), "Options selected are : Washington");
    }
}