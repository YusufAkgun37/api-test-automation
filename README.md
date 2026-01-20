# API Test Automation Framework 🚀

This project is a comprehensive API test automation framework designed for the **Restful Booker API**. It demonstrates industry-standard practices for API testing, performance testing, and CI/CD integration, serving as a professional portfolio for a Junior Test Engineer roles.

## 🌟 Key Features

- **E2E CRUD Testing**: Full lifecycle testing of bookings (Create, Read, Update, Delete).
- **Domain-Specific Language (DSL)**: Abstraction layer for clean and readable test code.
- **POJO Modeling**: Using Java objects for JSON serialization/deserialization (Jackson + Lombok).
- **Authentication**: Automatic token management for secure endpoints.
- **Performance Testing**: Load testing scenarios using **Apache JMeter**.
- **Rich Reporting**: Beautiful, detailed reports via **Allure Reports**.
- **CI/CD Integration**: Automated test execution on every push using **GitHub Actions**.

## 🛠 Tech Stack

- **Language**: Java 11
- **Testing Framework**: TestNG
- **API Client**: RestAssured
- **Data Handling**: Jackson Databind, Lombok (Builder Pattern)
- **Performance**: JMeter (Maven Plugin)
- **Reporting**: Allure Reports
- **CI/CD**: GitHub Actions

## 📂 Project Structure

```text
api-test-automation/
├── src/main/java/              # Core Logic
│   ├── api/                    # API Request wrappers (RestResource, BookingApi)
│   ├── models/                 # POJO classes for JSON mapping
│   └── utils/                  # Utility classes (ConfigReader)
├── src/test/java/              # Test Suites
│   └── tests/                  # TestNG test classes (BaseTest, BookingTests)
├── src/test/resources/         # Config and Properties files
├── jmeter/                     # JMeter Test Plans (.jmx)
├── .github/workflows/          # CI/CD Pipeline configuration
├── testng.xml                  # Test suite definition
└── pom.xml                     # dependency management
```

## 🚀 Getting Started

### Prerequisites
- JDK 11 or higher
- Maven 3.6+
- Git

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/YusufAkgun37/api-test-automation.git
   ```
2. Navigate to the project directory:
   ```bash
   cd api-test-automation
   ```

## 🧪 Running Tests

### Functional Tests (TestNG)
To run all functional tests:
```bash
mvn clean test
```

### Performance Tests (JMeter)
To run the load testing scenario and generate reports:
```bash
mvn com.lazerycode.jmeter:jmeter-maven-plugin:3.7.0:configure@configuration com.lazerycode.jmeter:jmeter-maven-plugin:3.7.0:jmeter@jmeter-tests
```

## 📊 Reporting

### Allure Reports
After running functional tests, generate the report:
1. Ensure Allure CLI is installed.
2. Run:
   ```bash
   allure serve target/allure-results
   ```

### JMeter Reports
HTML performance reports are automatically generated after running JMeter tests at:
`target/jmeter/reports/BookingApiLoadTest`

## 🌉 CI/CD Pipeline
The project uses **GitHub Actions** to:
- Run functional tests automatically on every `push` to `main`.
- Upload Allure results and Surefire reports as build artifacts.

---
Created by [Yusuf Akgun](https://github.com/YusufAkgun37)
