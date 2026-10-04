package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitUtility {

    private WaitUtility() {
    }

    public static WebElement visible(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        ConfigReader.getInt(
                                "explicitWait",
                                15)))
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        locator));
    }

    public static WebElement clickable(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        ConfigReader.getInt(
                                "explicitWait",
                                15)))
                .until(
                        ExpectedConditions
                                .elementToBeClickable(
                                        locator));
    }
    
    public static boolean invisible(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        ConfigReader.getInt(
                                "explicitWait",
                                15)))
                .until(
                        ExpectedConditions
                                .invisibilityOfElementLocated(locator));
    }

    public static boolean urlContains(
            WebDriver driver,
            String value) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        ConfigReader.getInt(
                                "explicitWait",
                                15)))
                .until(
                        ExpectedConditions
                                .urlContains(value));
    }

    public static boolean titleIs(
            WebDriver driver,
            String value) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        ConfigReader.getInt(
                                "explicitWait",
                                15)))
                .until(
                        ExpectedConditions
                                .titleIs(value));
    }
}