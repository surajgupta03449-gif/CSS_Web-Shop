package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.Constants;

public final class ScreenshotUtility {

    private ScreenshotUtility() {
    }

    public static String capture(
            WebDriver driver,
            String testName) {

        try {

            Path folder =
                    Paths.get(
                            Constants.SCREENSHOT_FOLDER);

            Files.createDirectories(folder);

            String timestamp =
                    new SimpleDateFormat(
                            "yyyyMMdd_HHmmss_SSS")
                            .format(new Date());

            String safeName =
                    testName.replaceAll(
                            "[^a-zA-Z0-9._-]",
                            "_");

            String fileName =
                    safeName
                            + "_"
                            + timestamp
                            + ".png";

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(
                                    OutputType.FILE);

            Path destination =
                    folder.resolve(fileName);

            Files.copy(
                    source.toPath(),
                    destination);

            /*
             * ExtentReport.html is inside reports/,
             * therefore screenshots/filename.png
             * is the correct relative path.
             */
            return "screenshots/" + fileName;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture screenshot",
                    e);
        }
    }
}