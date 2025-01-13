package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.SimpleFormPage;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static navigation.ApplicationURLs.SIMPLE_FORM_URL;
import static org.testng.Assert.assertEquals;

public class SimpleFormTests extends TestBase{
    @Test
    public void fillingSimpleFormWithBasicTextTest() {
        DriverUtils.navigateToPage(SIMPLE_FORM_URL);
        SimpleFormPage simpleFormPage = new SimpleFormPage();
        simpleFormPage
                .typeIntoInputMessageField("hello world")
                .clickShowMessageButton();
        String message = simpleFormPage.getMessage();
        assertEquals(message, "hello world");
    }

    @Test
    public void openingTheMainPageTest() {
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Test
    public void fillingTwoInputFieldsFormTest() {
        DriverUtils.navigateToPage(SIMPLE_FORM_URL);
        SimpleFormPage simpleFormPage = new SimpleFormPage();
        simpleFormPage
                .typeIntoEnterAInputField("2")
                .typeIntoEnterBInputField("3")
                .clickGetTotalButton();
        String totalValue = simpleFormPage.getTotalValue();
        assertEquals(totalValue, "5");
    }
}