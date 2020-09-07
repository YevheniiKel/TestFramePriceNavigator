package driverSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static util.PropertyReader.getProperty;

class BrowserFactory {

    public static WebDriver getDriver1(String name) {
        switch (getProperty(name)) {
            case "FIREFOX" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case "CHROME" -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case "EDGE" -> {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default -> {
                throw new IllegalArgumentException(
                        "Unknown browser. Please, edit config.properties"
                );
            }
        }
    }
}