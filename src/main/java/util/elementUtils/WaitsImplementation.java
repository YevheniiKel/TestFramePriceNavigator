package util.elementUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public interface WaitsImplementation extends WebDriver {
    long TIMEOUT = 10;

    default void clickWhenReady(WebElement element) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    default void clickAllWhenReady(List<WebElement> elements) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(ExpectedConditions.visibilityOfAllElements(elements));
        for (WebElement el : elements) {
            el.click();
        }
    }

    default void tillElementsPresent(List<WebElement> elements) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    default void tillElementPresent(WebElement element) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    default boolean tillTextEqualsValue(WebElement element, String value) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(text -> element.getText().equals(value));
        return true;
    }

    default void tillElementContainAnyText(WebElement element) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(el -> element.getText().length() != 0);
    }

    default void sendKeysWhenReadyThenEnter(WebElement element, String value) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element)).sendKeys(value, Keys.ENTER);
    }

    default void sendKeysWhenReady(WebElement element, String value) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    default void tillElementInvisible(WebElement element) {
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(ExpectedConditions.invisibilityOf(element));
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

    default boolean tillTextInElementEqualsValue(WebElement element, String value) {
        System.out.println(element.getText());
        new WebDriverWait(WaitsImplementation.this, TIMEOUT)
                .until(text -> element.getText().equals(value));
        return true;
    }

    default boolean isElementContainSomeText(WebElement element, String text) {
        return tillTextInElementEqualsValue(element, text);
    }
}
