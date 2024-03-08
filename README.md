# SDET Portfolio: Java Test Engine

[![codecov](https://codecov.io/gh/KurtiViktor/qa_portfolio-java-test_engine/branch/master/graph/badge.svg)](https://codecov.io/gh/KurtiViktor/qa_portfolio-java-test_engine)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Overview
Welcome to a cutting-edge demo showcasing the automation of testing for graphical user interfaces, APIs, and application databases. Designed for testers and developers alike, this project leverages modern technologies to streamline and enhance testing processes.

## Key Features

- **Parallel Execution**: Out-of-the-box support with Junit 5 for enhanced testing efficiency.
### Web Testing:
  - Harness the full potential of the Selenide library for robust web testing.
  - Element highlighting during local runs for improved test clarity.
  - Test execution video recording.
  - Comprehensive Allure reports for detailed insights.
  - Future plans include influxdb + grafana integration for advanced reporting.
### API Testing:
  - Seamless API interactions through Retrofit.
  - Test data management via JSON.
  - Functional mocking with Wiremock for reliable testing scenarios.
### Database Testing:
  - ORM-based database interactions with JPA/Hibernate for streamlined data testing.

## Getting Started

1. **Project Setup**: Clone the repository to get started with the test engine.
2. **Configuration**:
   - `concurrentExec`: Boolean value to enable/disable parallel test execution.
   - `tags`: Specify tags (`api`, `web`, `db`, `ext`) for selective test execution.
3. **Commands**:
   - Execute tests: `./gradlew test -Ptags=<tag_value> -PconcurrentExec=<boolean>`
   - Generate Allure reports: `./gradlew copyAllureCategories allureReport`
   - Generate Javadoc: `./gradlew javadoc`

## Project Structure

- `test_engine.api`: Package dedicated to API testing.
- `test_engine.db`: Package for database testing.
- `test_engine.ext`: Package for extensions and custom library usage.
- Additional details are available in the Javadoc documentation.

## Technology Stack

- **Build System**: Gradle 5.x
- **Programming Language**: Java 8 (Guava, Lombok, Owner, Gson)
- **Web Testing**: Selenide, video-recorder
- **API Testing**: Retrofit 2, Wiremock
- **Database**: Hibernate 5, JPA, SQLITE 3
- **Testing**: Junit 5, assertj
- **Reporting**: SLF4J, Log4j2, Allure 2.x
