package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Util {


    public static void clickTheElementsTimes(int times, List<WebElement> elements) {
        for (int i = 0; i < times; i++) {
            elements.get(i).click();
        }
    }
}
