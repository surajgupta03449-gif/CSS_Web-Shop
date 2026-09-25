package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.ProductPage;

public class ProductTest extends BaseClass {

    @Test
    public void addFirstBookToCartTest() {

        HomePage home =
                new HomePage(driver);

        home.openBooks();

        ProductPage product =
                new ProductPage(driver);

        product.addFirstProductToCart();

        Assert.assertTrue(
                product.isCartNotificationDisplayed(),
                "Cart notification was not displayed."
        );
    }
}