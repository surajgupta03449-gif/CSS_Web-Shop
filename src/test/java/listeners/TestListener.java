package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import utilities.ExtentManager;
import utilities.ScreenshotUtility;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> TEST =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        String className =
                result.getTestClass().getName();

        ExtentTest extentTest =
                ExtentManager.getExtentReports()
                        .createTest(testName)
                        .assignCategory(className);

        TEST.set(extentTest);

        TEST.get().log(
                Status.INFO,
                "Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        if (TEST.get() != null) {

            TEST.get().pass(
                    "Test passed successfully");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        if (TEST.get() == null) {
            return;
        }

        if (result.getThrowable() != null) {

            TEST.get().fail(
                    result.getThrowable());
        }

        Object instance =
                result.getInstance();

        if (instance instanceof BaseClass) {

            BaseClass base =
                    (BaseClass) instance;

            if (base.getDriver() != null) {

                try {

                    String screenshotPath =
                            ScreenshotUtility.capture(
                                    base.getDriver(),
                                    result.getMethod()
                                            .getMethodName());

                    TEST.get().fail(
                            "Failure screenshot",
                            MediaEntityBuilder
                                    .createScreenCaptureFromPath(
                                            screenshotPath)
                                    .build());

                } catch (Exception e) {

                    TEST.get().warning(
                            "Screenshot could not be captured: "
                                    + e.getMessage());
                }
            }
        }
    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        if (TEST.get() != null) {

            TEST.get().skip(
                    "Test skipped");
        }
    }

    @Override
    public void onFinish(
            ITestContext context) {

        ExtentManager.flush();

        TEST.remove();
    }
}