package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartTest extends BaseClass {

    @Test
    public void verifyCartAfterAddingBook() {

        HomePage home =
                new HomePage(driver);

        home.openBooks();

        ProductPage product =
                new ProductPage(driver);

        product.addFirstProductToCart();

        home.openCart();

        CartPage cart =
                new CartPage(driver);

        String actualTitle =
                cart.getTitleText();

        Assert.assertEquals(
                actualTitle,
                "Shopping cart",
                "Cart page title is incorrect."
        );
    }
}