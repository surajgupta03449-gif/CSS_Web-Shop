package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CheckoutTest extends BaseClass {

    @Test
    public void verifyCheckoutButtonFromCart() {

        HomePage home =
                new HomePage(driver);

        home.openBooks();

        ProductPage product =
                new ProductPage(driver);

        product.addFirstProductToCart();

        home.openCart();

        CartPage cart =
                new CartPage(driver);

        Assert.assertTrue(
                cart.isCheckoutButtonDisplayed(),
                "Checkout button is not displayed on the cart page."
        );

        cart.acceptTermsAndCheckout();
    }
}