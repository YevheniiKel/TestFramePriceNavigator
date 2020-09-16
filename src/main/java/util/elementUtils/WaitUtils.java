package util.elementUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitUtils {

    public WebDriverWait webDriverWait;

    public WaitUtils(WebDriver driver) {
        this.webDriverWait = new WebDriverWait(driver, 4);
    }

    public void waitMainElementAppear(WebElement element) {
        tillElementPresent(element);
    }

    public void waitMainElementsAppear(List<WebElement> elements) {
        tillElementsPresent(elements);
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

    public void tillTextInElementChanged(WebElement element, String baseValue) {
        webDriverWait.until(text -> !element.getText().equals(baseValue));
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
}

