package tests;

import org.testng.annotations.Test;
import page.objects.BasicExamplesPage;
import page.objects.LandingPage;
import page.objects.SimpleFormPage;

import static org.testng.Assert.assertEquals;

public class SimpleFormTests extends TestBase{
    @Test
    public void fillingSimpleFormWithBasicTextTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickSimpleFormDemoButton()
                .typeIntoInputMessageField("hello world")
                .clickShowMessageButton();
        SimpleFormPage simpleFormPage = new SimpleFormPage();
        String message = simpleFormPage.getMessage();
        assertEquals(message, "hello world");
    }

    @Test
    public void fillingTwoInputFieldsFormTest() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnStartButton()
                .clickSimpleFormDemoButton()
                .typeIntoEnterAInputField("2")
                .typeIntoEnterBInputField("3")
                .clickGetTotalButton();
        SimpleFormPage simpleFormPage = new SimpleFormPage();
        String totalValue = simpleFormPage.getTotalValue();
        assertEquals(totalValue, "5");
    }
}
