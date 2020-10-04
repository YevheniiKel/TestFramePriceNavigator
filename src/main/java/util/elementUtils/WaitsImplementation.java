package util.elementUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public interface WaitsImplementation {

    WebDriverWait webDriverWait = null;
    Wait<WebDriver> fluentWait = null;

//    publi1c WaitUtils(WebDriver driver) {
//        this.webDriverWait = new WebDriverWait(driver, 4);
//        this.fluentWait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
//    }

    default void clickWhenReady(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    default void clickAllWhenReady(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
        for (WebElement el : elements) {
            el.click();
        }
    }

    default void tillElementsPresent(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    default void tillElementPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    default boolean tillTextEqualsValue(WebElement element, String value) {
        webDriverWait.until(text -> element.getText().equals(value));
        return true;
    }

    default void tillElementContainAnyText(WebElement element) {
        webDriverWait.until(el -> element.getText().length() != 0);
    }

    default void sendKeysWhenReadyThenEnter(WebElement element, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value, Keys.ENTER);
    }

    default void sendKeysWhenReady(WebElement element, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    default void tillElementInvisible(WebElement element) {
        fluentWait.until(ExpectedConditions.invisibilityOf(element));
    }

    default boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    default void clickElementFromList(List<WebElement> elements, int index) {
        clickWhenReady(elements.get(index));
    }

    default String getTextFromElement(WebElement element) {
        tillElementContainAnyText(element);
        return element.getText();
    }
}
