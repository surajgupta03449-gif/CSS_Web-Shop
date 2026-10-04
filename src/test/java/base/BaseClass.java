package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;

public class BaseClass {

    protected WebDriver driver;

    protected final Logger logger =
            LogManager.getLogger(getClass());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        String browser =
                ConfigReader.getProperty("browser");

        if (browser == null || browser.isBlank()) {
            browser = "chrome";
        }

        browser = browser.trim().toLowerCase();

//        boolean headless =
//                ConfigReader.getBoolean("headless", false);

        String headlessProperty = System.getProperty("headless");

        boolean headless;

        if (headlessProperty != null) {
            headless = Boolean.parseBoolean(headlessProperty);
        } else {
            headless = ConfigReader.getBoolean("headless", false);
        }
        
        switch (browser) {

        case "chrome":

            ChromeOptions chromeOptions =
                    new ChromeOptions();

            if (headless) {
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--window-size=1920,1080");
            }

            driver = new ChromeDriver(chromeOptions);
            break;

        case "edge":

            EdgeOptions edgeOptions =
                    new EdgeOptions();

            if (headless) {
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--window-size=1920,1080");
            }

            driver = new EdgeDriver(edgeOptions);
            break;

        case "firefox":

            FirefoxOptions firefoxOptions =
                    new FirefoxOptions();

            if (headless) {
                firefoxOptions.addArguments("-headless");
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
            }

            driver = new FirefoxDriver(firefoxOptions);
            break;

        default:

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        }

        if (!headless) {
            driver.manage().window().maximize();
        }

        int implicitWait =
                ConfigReader.getInt("implicitWait", 5);

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(implicitWait));

        int pageLoadTimeout =
                ConfigReader.getInt("pageLoadTimeout", 30);

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(pageLoadTimeout));

        String url =
                ConfigReader.getProperty("baseUrl");

        if (url == null || url.isBlank()) {

            throw new IllegalStateException(
                    "baseUrl is missing in config.properties");
        }

        logger.info("========================================");
        logger.info("Browser: {}", browser);
        logger.info("Headless: {}", headless);
        logger.info("Opening application: {}", url);
        logger.info("========================================");

        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {

            logger.info("Closing browser");

            driver.quit();

            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}