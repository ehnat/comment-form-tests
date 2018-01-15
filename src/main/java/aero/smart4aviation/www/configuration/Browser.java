package aero.smart4aviation.www.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Browser {
    FIREFOX {
        @Override
        public WebDriver newDriver() {
            System.setProperty("webdriver.gecko.driver", Configuration.CONFIGURATION.getValue("pathToFirefoxDriver"));
            return new FirefoxDriver();
        }
    },
    CHROME {
        @Override
        public WebDriver newDriver() {
            System.setProperty("webdriver.chrome.driver", Configuration.CONFIGURATION.getValue("pathToChromeDriver"));
            return new ChromeDriver();
        }
    };

    public abstract WebDriver newDriver();
}
