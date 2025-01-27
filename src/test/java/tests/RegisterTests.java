package tests;

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


}