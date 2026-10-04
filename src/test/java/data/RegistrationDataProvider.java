package data;

import org.testng.annotations.DataProvider;

import constants.Constants;
import utilities.ExcelUtility;

public class RegistrationDataProvider {

    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {

        return ExcelUtility.getData(
                Constants.TEST_DATA_FILE,
                "RegistrationData");
    }
}