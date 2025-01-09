package tests;

import org.testng.annotations.Test;
import page.objects.MainPage;
import waits.OtherWaits;

import static org.testng.Assert.assertEquals;

public class NewsletterTests extends TestBase{
    @Test
    public void fillingNewsletterSignUpField() {
        MainPage mainPage = new MainPage();
        mainPage.typeIntoNewsletterSignUp("abc@gmail.com");

        String newsletterFieldValue = mainPage.getNewsletterFieldValue();
        assertEquals(newsletterFieldValue, "abc@gmail.com");
    }

    @Test
    public void clickingSubscribeButton() {
        MainPage mainPage = new MainPage();
        mainPage.typeIntoNewsletterSignUp("abc@gmail.com");
        mainPage.clickSubscribeButton();
        OtherWaits.waitForXSeconds("2");

        String newsletterSubscriptionConfirmationMessage = mainPage.getNewsletterSubscribeBlockMessage();
        assertEquals(newsletterSubscriptionConfirmationMessage, "Thank you for signing up! A verification email has been sent. We appreciate your interest.");
    }
}
