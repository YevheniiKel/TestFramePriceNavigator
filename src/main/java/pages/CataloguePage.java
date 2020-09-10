package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static util.elementUtils.UtilActionsWithElements.clickTheElementsTimes;

public class CataloguePage extends BasePage {

    @FindBy(className = "catalog")
    WebElement catalogue;

    @FindBy(className = "add-to-compare-link")
    List<WebElement> addToCompareButtonPath;

    @FindBy(xpath = "//span[@class='add-to-compare']/../span[@class='remove-from-compare']/a[contains(text(),'сравнить')]")
    WebElement compareButtonPath;


    private List<WebElement> addToCompareButtons;

    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCatalogueIsDisplayed() {
        try {
            return catalogue.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void addThreeProductsToComparing() {
        addToCompareButtons = addToCompareButtonPath;
        clickTheElementsTimes(3, addToCompareButtons);
    }

    public void clickCompare() {
        compareButtonPath.click();
    }
}
