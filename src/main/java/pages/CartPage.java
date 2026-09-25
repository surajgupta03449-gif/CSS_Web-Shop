package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class CartPage {

    private final WebDriver driver;

    private final By cartTitle =
            By.cssSelector(".page-title h1");

    private final By termsOfService =
            By.id("termsofservice");

    private final By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return WaitUtility.visible(
                driver,
                cartTitle
        ).getText();
    }

    public boolean isCheckoutButtonDisplayed() {
        return WaitUtility.visible(
                driver,
                checkoutButton
        ).isDisplayed();
    }

    public void acceptTermsAndCheckout() {

        WaitUtility.clickable(
                driver,
                termsOfService
        ).click();

        WaitUtility.clickable(
                driver,
                checkoutButton
        ).click();
    }
}