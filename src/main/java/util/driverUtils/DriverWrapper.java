package util.driverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.elementUtils.WaitsImplementation;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DriverWrapper implements WebDriver, WaitsImplementation {

    public WebDriver driver;

    public DriverWrapper(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void get(String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void quiteDriver() {
        if (Objects.nonNull(driver))
            try {
                driver.manage().deleteAllCookies();
            } catch (Exception ex) {
                System.out.println(String.format("An  exception  occurred while cookie deleting: %s", ex));
            }
        try {
            driver.close();
        } catch (Exception ex) {
            System.out.println(String.format("An  exception  occurred while driver closing: %s", ex));
        }
        try {
            driver.quit();
        } catch (Exception ex) {
            System.out.println(String.format("An  exception  occurred while cookie deleting: %s", ex));
        }
        driver = null;
    }
}

