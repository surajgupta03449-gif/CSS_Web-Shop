package utilities;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static synchronized ExtentReports getExtentReports() {
        if (extent == null) {
            try {
                Path reports = Paths.get("reports");
                Files.createDirectories(reports);

                ExtentSparkReporter spark =
                        new ExtentSparkReporter("reports/ExtentReport.html");

                spark.config().setDocumentTitle("Web Shop Automation Report");
                spark.config().setReportName("Web Shop Selenium Test Report");

                extent = new ExtentReports();
                extent.attachReporter(spark);

                extent.setSystemInfo("Project", "Web_shop_corrected");
                extent.setSystemInfo("Application",
                        "Demo Web Shop");
                extent.setSystemInfo("Framework",
                        "Selenium + TestNG + Maven + POM");
                extent.setSystemInfo("Browser",
                        ConfigReader.getProperty("browser"));

            } catch (Exception e) {
                throw new RuntimeException(
                        "Unable to initialize Extent Reports", e);
            }
        }

        return extent;
    }

    public static synchronized void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
