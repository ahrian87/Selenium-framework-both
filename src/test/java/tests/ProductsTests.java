package tests;

import org.testng.annotations.Test;
import page.objects.LeftMenuPage;
import page.objects.ProductPage;
import page.objects.TopNaviPage;
import page.objects.categories.ApparelAndShoesPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTests extends TestBase {

    @Test
    public void asLoggedInUserAddProductToWishlist() {
        LeftMenuPage leftMenuPage = new LeftMenuPage();
        leftMenuPage.clickApparelAndShoesCategory();

        ApparelAndShoesPage apparelAndShoesPage = new ApparelAndShoesPage();
        assertEquals(apparelAndShoesPage.getPageTitle(), "Apparel & Shoes");
        apparelAndShoesPage.clickBlueAndGreenSneaker();

        ProductPage productPage = new ProductPage();
        assertEquals(productPage.getProductName(), "Blue and green Sneaker");
        productPage.clickAddToWishlistButton();
        assertTrue(productPage.isBarNotificationVisible());

        TopNaviPage topNaviPage = new TopNaviPage();
        topNaviPage.clickWishlistButton();

    }

}
