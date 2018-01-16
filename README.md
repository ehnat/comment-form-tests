### Project description
NOTICE!
This project is based on sample data so it can't be run.
This project contains sample functional tests which are written to the form to send comments.
Tests can be run on Chrome or Firefox browser. Tests are prepared to running on Windows.

### Technical description
- **Used technologies:** Java 8, Maven
- **Used frameworks/libraries:** Selenium Webdriver, TestNG, AssertJ
- **Used patterns:** Page Object Pattern, Page Factory

### Necessary to download/install to run the project
1. install Java 8
2. install Maven
3. install Chrome browser and Firefox browser
4. download chromedriver for Windows [here](https://sites.google.com/a/chromium.org/chromedriver/downloads)
   (preferred v.2.35) and unzip
5. download geckodriver for Windows [here](https://github.com/mozilla/geckodriver/releases)
   (preferred v.0.19.1) and unzip

### How to run test
1. clone this repo
2. put downloaded and unziped drivers in the folder **src/test/resources/**
3. enter to the folder **comment-form-tests** (place where file 'pom.xml' is located)
4. run command from command line:
- for Chrome:
  ```sh
    mvn clean test
  ```
    or
   ```sh
   mvn clean test -P chrome
   ```
- for Firefox:
   ```sh
   mvn clean test -P firefox
   ```
