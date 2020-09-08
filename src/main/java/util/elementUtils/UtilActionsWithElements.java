package util.elementUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UtilActionsWithElements {

    public static boolean isElementDisplayed(WebDriver driver, By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clickTheElementsTimes(int times, List<WebElement> elements) {
        for (int i = 0; i < times; i++) {
            elements.get(i).click();
        }
    }
}
