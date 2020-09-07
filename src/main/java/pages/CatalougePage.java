package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CatalougePage {

    private WebDriver driver;
    private By catalogue = By.className("catalog");

    public CatalougePage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isCatalogueIsDisplayed() {
        try {
            return driver.findElement(catalogue).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
