package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class HomePage {

    private final WebDriver driver;

    private final By registerLink =
            By.cssSelector("a.ico-register");

    private final By loginLink =
            By.cssSelector("a.ico-login");

    private final By booksLink =
            By.cssSelector("a[href='/books']");

    private final By computersLink =
            By.cssSelector("a[href='/computers']");

    private final By electronicsLink =
            By.cssSelector("a[href='/electronics']");

    private final By cartLink =
            By.cssSelector("a.ico-cart");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void openRegistration() {
        WaitUtility
                .clickable(driver, registerLink)
                .click();
    }

    public void openLogin() {
        WaitUtility
                .clickable(driver, loginLink)
                .click();
    }

    public void openBooks() {
        WaitUtility
                .clickable(driver, booksLink)
                .click();
    }

    public void openComputers() {
        WaitUtility
                .clickable(driver, computersLink)
                .click();
    }

    public void openElectronics() {
        WaitUtility
                .clickable(driver, electronicsLink)
                .click();
    }

    public void openCart() {

        WaitUtility
                .invisible(driver, By.id("bar-notification"));

        WaitUtility
                .clickable(driver, cartLink)
                .click();
    }
}