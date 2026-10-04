# Web Shop Selenium Automation Framework

A Java-based Selenium Web Automation Framework using Selenium WebDriver, TestNG, Maven, Page Object Model, Apache POI, Extent Reports, and Log4j2.

## Project Overview

This project is a Selenium automation framework for testing the Demo Web Shop application.

The framework is designed to perform functional and regression testing of web application features using Page Object Model and reusable automation utilities.

## Application Under Test

Demo Web Shop:

`https://demowebshop.tricentis.com/`

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming Language |
| Selenium WebDriver | Web Automation |
| TestNG | Test Execution |
| Maven | Build & Dependency Management |
| Page Object Model | Framework Design |
| Apache POI | Excel Test Data |
| Extent Reports | Test Reporting |
| Log4j2 | Logging |
| Git & GitHub | Version Control |
| GitHub Actions | CI/CD |

## Framework Features

- Selenium WebDriver automation
- TestNG test execution
- Maven project management
- Page Object Model
- Excel DataProvider using Apache POI
- Extent Spark Reports
- Failure screenshots
- Explicit waits
- Configurable browser and URL
- Log4j2 logging
- Headless browser execution
- Automated GitHub Actions execution
- GitHub Pages test report

## Project Structure

```text
CSS_Web-Shop
│
├── .github
│   └── workflows
│       └── GitHub Actions workflows
│
├── .vscode
│
├── TestData
│   └── TestData.xlsx
│
├── reports
│   ├── ExtentReport.html
│   └── screenshots
│
├── src
│   ├── main
│   └── test
│
├── test-output
│
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

## Testing

The framework supports testing scenarios such as:

- Login
- Product selection
- Shopping cart
- Checkout
- Functional validation
- Regression testing
- UI validation

## Test Data

Excel-based test data is maintained in:

```text
TestData/TestData.xlsx
```

Apache POI is used to read test data during test execution.

## Reports

Extent Spark Report:

```text
reports/ExtentReport.html
```

Failure screenshots:

```text
reports/screenshots/
```

TestNG results:

```text
test-output/
```

## How to Run

### Clone the Repository

```bash
git clone https://github.com/surajgupta03449-gif/CSS_Web-Shop.git
```

### Navigate to the Project

```bash
cd CSS_Web-Shop
```

### Run Tests

```bash
mvn clean test
```

### Run Tests in Headless Mode

```bash
mvn clean test -Dheadless=true
```

## GitHub Actions

The project uses GitHub Actions to automatically execute Selenium tests.

Workflow:

```text
GitHub Push
     ↓
GitHub Actions
     ↓
Java 21
     ↓
Maven
     ↓
Selenium Tests
     ↓
TestNG
     ↓
Extent Report
     ↓
GitHub Pages
```

## GitHub Pages Report

The latest Selenium test report is published through GitHub Pages.

[View Selenium Test Report](https://surajgupta03449-gif.github.io/CSS_Web-Shop/)

## Configuration

The framework supports configuration through:

```text
src/test/resources/config.properties
```

Configuration includes:

- Browser
- URL
- Headless execution
- Explicit wait

## Java Version

The project is configured for:

```text
Java 21
```

Selenium Manager can automatically resolve the browser driver.

## Author

**Suraj Gupta**

QA Engineer Fresher | Software Testing | Selenium | API Automation | Playwright

GitHub:

https://github.com/surajgupta03449-gif
