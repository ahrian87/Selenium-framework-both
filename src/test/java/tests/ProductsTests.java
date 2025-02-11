package tests;

import org.testng.annotations.Test;
import page.objects.*;
import page.objects.categories.ApparelAndShoesPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTests extends TestBase {

    @Test
    public void asLoggedInUserAddAndRemoveProductFromWishlist() {
        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickLoginButton();

        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.getWelcomeMessageTest(), "Welcome, Please Sign In!");

        loginPage.typeIntoEmailField("mac.zet.test@gmail.com");
        loginPage.typeIntoPasswordField("123456");
        loginPage.clickLoginButton();

        assertTrue(topNaviPage.isAccountLoginVisible());

        LeftMenuPage leftMenuPage = new LeftMenuPage();
        leftMenuPage.clickApparelAndShoesCategory();

        ApparelAndShoesPage apparelAndShoesPage = new ApparelAndShoesPage();
        assertEquals(apparelAndShoesPage.getPageTitle(), "Apparel & Shoes");
        apparelAndShoesPage.clickBlueAndGreenSneaker();

        ProductPage productPage = new ProductPage();
        assertEquals(productPage.getProductName(), "Blue and green Sneaker");
        productPage.clickAddToWishlistButton();
        assertTrue(productPage.isBarNotificationVisible());

        topNaviPage.clickWishlistButton();

        WishlistPage wishlistPage = new WishlistPage();
        assertEquals(wishlistPage.getPagetitle(), "Wishlist");
        assertTrue(wishlistPage.isRemoveCheckboxVisible());

        wishlistPage.clickRemoveFromCartCheckbox();
        wishlistPage.clickUpdateCartButton();
        assertEquals(wishlistPage.getWishlistContentMessage(), "The wishlist is empty!");

        topNaviPage.clickLogOutButton();
    }

}
