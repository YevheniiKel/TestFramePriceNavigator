package util.elementUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitUtils {

    public static WebDriverWait webDriverWait;

    public static void sleepSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void waitTillElementClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTillMultElementsPresent(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public static void waitTillElementPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitTillElementContainText(WebElement element) {
        webDriverWait.until(el -> element.getText().length() != 0);
    }
}

