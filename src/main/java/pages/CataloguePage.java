package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CataloguePage extends HeaderAnyPage {

    private List<WebElement> addToCompareButtons;

    public CataloguePage(WebDriver driver) {
        super(driver);
        waitForMainElements();
    }

    @FindBy(xpath = ".//section[@class='catalog']")
    WebElement catalogue;

    @FindBy(xpath = ".//a[@class='add-to-compare-link']")
    List<WebElement> addToCompareButtonPath;

    @FindBy(xpath = ".//a[contains(@href, '/compare/')]")
    WebElement compareButtonPath;

    @Override
    public void waitForMainElements() {
        wait.tillElementPresent(catalogue);
    }

    @Override
    public CataloguePage openPage() {
        throw new UnsupportedOperationException("This page should not be loaded directly");
    }

    public boolean isCatalogueIsDisplayed() {
        try {
            return catalogue.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void addProductsToComparing(Integer amount) {
        addToCompareButtons = addToCompareButtonPath;
        if (addToCompareButtons.size() >= amount) {
            wait.clickAllWhenReady(addToCompareButtons.subList(0, amount));
        } else {
            throw new NoSuchElementException("Amount of elements is less than 3");
        }
    }

    public ComparingPage clickCompare() {
        wait.clickWhenReady(compareButtonPath);
        return new ComparingPage(driver);
    }
}
