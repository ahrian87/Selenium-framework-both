package tests;

import org.testng.annotations.Test;
import page.objects.TopNaviPage;

public class RegisterTests extends TestBase{
    @Test
    public void clickRegisterButtonTest() {
        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickRegisterButton();
    }
}