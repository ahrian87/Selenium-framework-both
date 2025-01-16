package tests;

import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TopNaviPage;
import static org.testng.Assert.assertEquals;

public class LoginTests extends TestBase{

    @Test
    public void clickLoginButtonTest() {
        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickLoginButton();

        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.getWelcomeMessageTest(), "Welcome, Please Sign In!");
    }
}
