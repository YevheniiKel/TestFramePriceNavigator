package util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import steps.DriverManager;
import util.elementUtils.WaitUtils;

import java.util.List;

public class DriverW8Wrapper extends DriverManager {
    private WaitUtils wait;

    public DriverW8Wrapper() {
        this.wait = new WaitUtils(driver);
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickTheButton(WebElement element){
        wait.clickWhenReady(element);
    }

    public void clickElementFromList(List<WebElement> elements, int index){
        wait.clickWhenReady(elements.get(index));
    }

}
