package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class CheckoutPage {

    private final WebDriver driver;

    private final By checkoutAsGuest =
            By.cssSelector(
                    "input.button-1.checkout-as-guest-button");

    private final By loginMessage =
            By.cssSelector(".message-error");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCheckoutAsGuestDisplayed() {

        return WaitUtility
                .visible(driver, checkoutAsGuest)
                .isDisplayed();
    }

    public String getLoginMessage() {

        return WaitUtility
                .visible(driver, loginMessage)
                .getText();
    }
}