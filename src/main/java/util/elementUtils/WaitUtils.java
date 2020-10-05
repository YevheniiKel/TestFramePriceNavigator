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
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }

    public void clickWhenReady(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickAllWhenReady(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
        for (WebElement el : elements) {
            el.click();
        }
    }

    public void tillElementsPresent(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void tillElementPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean tillTextInElementEqualsValue(WebElement element, String value) {
        System.out.println(element.getText());
        fluentWait.until(text -> element.getText().equals(value));
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
        try{
            fluentWait.until(ExpectedConditions.invisibilityOf(element));
        }catch (NoSuchElementException ignored){

        }
    }
    public boolean isElementDisplayed( WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickElementFromList( List<WebElement> elements, int index) {
        clickWhenReady(elements.get(index));
    }

    public String getTextFromElement( WebElement element) {
        tillElementContainAnyText(element);
        return element.getText();
    }
    public boolean isElementContainSomeText(WebElement element, String text) {
        return tillTextInElementEqualsValue(element, text);
    }
}

