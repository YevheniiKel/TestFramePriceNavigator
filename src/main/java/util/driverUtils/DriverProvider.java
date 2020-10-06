package util.driverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static util.PropertyReader.getProperty;

public class DriverProvider {

    protected WebDriver driver;

    public DriverProvider() {
        this.driver = DriverProvider.createNewDriver();
    }

    private static DriverWrapper createNewDriver() {
        switch (getProperty("BROWSER")) {
            case "FIREFOX" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions()
                        .addArguments("start-maximized")
                        .addArguments("disable-infobars")
                        .addArguments("--headless");
                return new DriverWrapper(new FirefoxDriver());
            }
            case "CHROME" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions()
                        .addArguments("start-maximized")
                        .addArguments("disable-infobars");
                return new DriverWrapper(new ChromeDriver(options));
            }
            case "EDGE" -> {
                WebDriverManager.edgedriver().setup();
                return new DriverWrapper(new EdgeDriver());
            }
            default -> throw new IllegalArgumentException("Unknown browser. Please, edit config.properties");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}