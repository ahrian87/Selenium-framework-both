package tests;

import org.testng.annotations.Test;
import page.objects.RightMenuPage;
import waits.OtherWaits;

import static org.testng.Assert.assertEquals;

public class NewsletterTests extends TestBase{
    @Test
    public void fillingNewsletterSignUpFieldTest() {
        RightMenuPage rightMenuPage = new RightMenuPage();
        rightMenuPage.typeIntoNewsletterSignUp("abc@gmail.com");

        String newsletterFieldValue = rightMenuPage.getNewsletterFieldValue();
        assertEquals(newsletterFieldValue, "abc@gmail.com");
    }

    @Test
    public void subscribeToNewsletterTest() {
        RightMenuPage rightMenuPage = new RightMenuPage();
        rightMenuPage.typeIntoNewsletterSignUp("abc@gmail.com");
        rightMenuPage.clickSubscribeButton();
        OtherWaits.waitForXSeconds("2");

        String newsletterSubscriptionConfirmationMessage = rightMenuPage.getNewsletterSubscribeBlockMessage();
        assertEquals(newsletterSubscriptionConfirmationMessage, "Thank you for signing up! A verification email has been sent. We appreciate your interest.");
    }
}
