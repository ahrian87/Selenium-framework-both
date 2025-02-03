package tests;

import functions.FakeDataGenerator;
import org.testng.annotations.Test;
import page.objects.RegisterPage;
import page.objects.TopNaviPage;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends TestBase{
    @Test
    public void clickRegisterButtonTest() {
        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage();
        assertEquals(registerPage.getPageTitleValue(), "Register");
    }

    @Test
    public void asUserRegisterNewAccountTest() {
        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage();
        registerPage.clickMaleRadioButton();
        registerPage.typeIntoFirstNameField("Mac");
        registerPage.typeIntoLastNameField("Zet");
        registerPage.typeIntoEmailField(FakeDataGenerator.generateFakeEmail());
        registerPage.typeIntoPasswordField("123456");
        registerPage.confirmPassword("123456");
        registerPage.clickRegisterAccountButton();

        assertEquals(registerPage.getConfirmationMessageValue(), "Your registration completed");
        registerPage.clickContinueButton();
    }
}