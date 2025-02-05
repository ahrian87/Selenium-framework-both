package tests;

import org.testng.annotations.Test;
import page.objects.AddressesPage;
import page.objects.LoginPage;
import page.objects.MyAccountPage;
import page.objects.TopNaviPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountTests extends TestBase {

    @Test
    public void asLoggedInUserAddNewAddress() {
        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickLoginButton();

        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.getWelcomeMessageTest(), "Welcome, Please Sign In!");

        loginPage.typeIntoEmailField("mac.zet.test@gmail.com");
        loginPage.typeIntoPasswordField("123456");
        loginPage.clickLoginButton();
        topNaviPage.clickAccountName();

        MyAccountPage myAccountPage = new MyAccountPage();
        assertEquals(myAccountPage.getPageTitle(), "My account - Customer info");
        myAccountPage.clickAddressesButton();
        assertEquals(myAccountPage.getPageTitle(), "My account - Addresses");

        AddressesPage addressesPage = new AddressesPage();
        addressesPage.clickAddNewAddressButton();
        assertEquals(myAccountPage.getPageTitle(), "My account - Add new address");

        addressesPage.fillFirstNameField("Mac");
        addressesPage.fillLastNameField("Zet");
        addressesPage.fillEmailFieldWithRandomValue();
        addressesPage.selectCountry("Poland");
        addressesPage.fillCityField("Elk");
        addressesPage.fillAddressOneField("ul. Mickiewicza");
        addressesPage.fillZipCodeField("19-300");
        addressesPage.fillPhoneNumberFieldWithRandomValue();
        addressesPage.clickSaveButton();

        assertTrue(addressesPage.isDeleteButtonVisible());

        topNaviPage.clickLogOutButton();
    }
}
