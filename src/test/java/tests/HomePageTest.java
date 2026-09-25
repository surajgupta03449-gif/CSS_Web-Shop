package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import data.RegistrationDataProvider;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseClass {

    @Test
    public void verifyUrlTest() {

        HomePage home =
                new HomePage(driver);

        Assert.assertEquals(
                home.getUrl(),
                "https://demowebshop.tricentis.com/",
                "Home page URL is incorrect."
        );
    }

    @Test
    public void verifyTitleTest() {

        HomePage home =
                new HomePage(driver);

        Assert.assertEquals(
                home.getTitle(),
                "Demo Web Shop",
                "Home page title is incorrect."
        );
    }

    @Test(
        dataProvider = "registrationData",
        dataProviderClass = RegistrationDataProvider.class
    )
    public void verifyRegistrationWithExcelData(
            String testCaseId,
            String firstName,
            String lastName,
            String email,
            String password,
            String expectedMessage) {

        String uniqueEmail =
                email.replace(
                        "@",
                        "." + System.currentTimeMillis() + "@");

        HomePage home =
                new HomePage(driver);

        home.openRegistration();

        driver.findElement(
                By.id("gender-male")).click();

        driver.findElement(
                By.id("FirstName"))
                .sendKeys(firstName);

        driver.findElement(
                By.id("LastName"))
                .sendKeys(lastName);

        driver.findElement(
                By.id("Email"))
                .sendKeys(uniqueEmail);

        driver.findElement(
                By.id("Password"))
                .sendKeys(password);

        driver.findElement(
                By.id("ConfirmPassword"))
                .sendKeys(password);

        driver.findElement(
                By.id("register-button"))
                .click();

        String actualMessage =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(15))
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.cssSelector(".result")))
                .getText();

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Registration result mismatch for "
                        + testCaseId);
    }

    @Test
    public void verifyLoginPageNavigation() {

        HomePage home =
                new HomePage(driver);

        home.openLogin();

        LoginPage login =
                new LoginPage(driver);

        Assert.assertTrue(
                login.getTitle().contains("Login"),
                "Login page title does not contain Login."
        );
    }
}