package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class ProductPage {

    private final WebDriver driver;

    private final By firstAddToCart =
            By.cssSelector(
                    ".product-item input[value='Add to cart']");

    private final By notification =
            By.cssSelector(".bar-notification");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() {

        WaitUtility
                .clickable(driver, firstAddToCart)
                .click();

        WaitUtility
                .visible(driver, notification);
    }

    public boolean isCartNotificationDisplayed() {

        return WaitUtility
                .visible(driver, notification)
                .isDisplayed();
    }

    public String getCartNotificationText() {

        return WaitUtility
                .visible(driver, notification)
                .getText();
    }
}