package util.elementUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    public WebDriverWait webDriverWait;
    public Wait<WebDriver> fluentWait;

    public WaitUtils(WebDriver driver) {
        this.webDriverWait = new WebDriverWait(driver, 4);
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    public void clickWhenReady(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickAllWhenReady(List<WebElement> elements) {
        for (WebElement el : elements) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(el)).click();
        }
    }

    public void tillElementsPresent(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void tillElementPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean tillTextEqualsValue(WebElement element, String value) {
        webDriverWait.until(text -> element.getText().equals(value));
        return true;
    }

    public void tillElementContainAnyText(WebElement element) {
        webDriverWait.until(el -> element.getText().length() != 0);
    }

    public void sendKeysWhenReadyThenEnter(WebElement element, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value, Keys.ENTER);
    }

    public void sendKeysWhenReady(WebElement element, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    public void tillElementInvisible(WebElement element) {
        fluentWait.until(ExpectedConditions.invisibilityOf(element));
    }
}

