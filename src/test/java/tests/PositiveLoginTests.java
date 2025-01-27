package tests;

import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TopNaviPage;
import waits.WaitForElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void clickLoginButtonTest() {
        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickLoginButton();

        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.getWelcomeMessageTest(), "Welcome, Please Sign In!");
    }

    @Test
    public void asUserLoginWithCorrectLoginAndPassword() {
        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickLoginButton();

        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.getWelcomeMessageTest(), "Welcome, Please Sign In!");

        loginPage.typeIntoEmailField("mac.zet.test@gmail.com");
        loginPage.typeIntoPasswordField("123456");
        loginPage.clickLoginButton();

        assertTrue(topNaviPage.isAccountLoginVisible());
    }
}
