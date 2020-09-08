package driverSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static util.PropertyReader.getProperty;

class BrowserFactory {

    public static WebDriver getDriver() {
        switch (getProperty("BROWSER")) {
            case "FIREFOX" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions()
                        .addArguments("start-maximized")
                        .addArguments("disable-infobars")
                        .addArguments("--headless");
                return new FirefoxDriver();
            }
            case "CHROME" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions()
                        .addArguments("start-maximized")
                        .addArguments("disable-infobars")
                        .addArguments("--headless");
                return new ChromeDriver(options);
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