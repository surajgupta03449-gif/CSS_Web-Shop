# Web_shop_corrected

Selenium + TestNG + Maven + Page Object Model framework for Demo Web Shop.

## Framework features

- Page Object Model
- Selenium WebDriver
- TestNG
- Maven
- Excel DataProvider using Apache POI
- Extent Spark Report
- Failure screenshots
- Explicit waits
- Configurable browser and URL
- Log4j2 logging

## Run

```bash
mvn clean test
```

The Extent report is created at:

```text
reports/ExtentReport.html
```

Failure screenshots are created at:

```text
reports/screenshots/
```

Excel test data:

```text
TestData/TestData.xlsx
```

## Important

The project is configured for Java 21. Selenium Manager can automatically resolve the browser driver. If your environment blocks driver downloads, install a compatible browser driver or configure it in your PATH.
