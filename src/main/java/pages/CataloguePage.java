package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.CharDataForTestSite;

import java.util.List;

public class CataloguePage extends BasePage {

    private List<WebElement> addToCompareButtons;

    public CataloguePage(WebDriver driver) {
        super(driver);
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
        driver.get(CharDataForTestSite.HOME_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseAnySubCategory();
        waitForMainElements();
        return new CataloguePage(driver);

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
        if (addToCompareButtons.size() >= 3) {
            wait.clickAllWhenReady(addToCompareButtons.subList(0, 3));
        } else {
            throw new NoSuchElementException("Amount of elements is less than 3");
        }
    }

    public ComparingPage clickCompare() {
        wait.clickWhenReady(compareButtonPath);
        return new ComparingPage(driver);
    }
}
