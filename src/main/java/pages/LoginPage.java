package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class LoginPage {

    private final WebDriver driver;

    private final By email =
            By.id("Email");

    private final By password =
            By.id("Password");

    private final By loginButton =
            By.cssSelector("input.login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String value) {

        WaitUtility
                .visible(driver, email)
                .clear();

        driver.findElement(email)
                .sendKeys(value);
    }

    public void enterPassword(String value) {

        WaitUtility
                .visible(driver, password)
                .clear();

        driver.findElement(password)
                .sendKeys(value);
    }

    public void clickLogin() {

        WaitUtility
                .clickable(driver, loginButton)
                .click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}