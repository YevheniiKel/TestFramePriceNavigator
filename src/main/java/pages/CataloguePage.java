package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static util.UtilActionsWithElements.clickTheElementsTimes;

public class CataloguePage {

    private WebDriver driver;

    private Random r;

    private By catalogue = By.className("catalog");
    private By addToCompareButtonPath = By.className("add-to-compare-link");
    private By compareButtonPath = By.xpath("//span[@class='add-to-compare']/../span[@class='remove-from-compare']/a[contains(text(),'сравнить')]");

    private List<WebElement> addToCompareButtons;

    public CataloguePage(WebDriver driver) {
        this.driver = driver;
        this.r = new Random();
    }

    public boolean isCatalogueIsDisplayed() {
        try {
            return driver.findElement(catalogue).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public CataloguePage addThreeProductsToComparing() {
        addToCompareButtons = driver.findElements(addToCompareButtonPath);
        clickTheElementsTimes(3, addToCompareButtons);
        return this;
    }

    public void clickCompare() {
        driver.findElement(compareButtonPath).click();
    }
}
