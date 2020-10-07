package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.driverUtils.DriverWrapper;

import java.util.List;

import static java.lang.String.format;

public class CataloguePage extends BasePage {

    public List<WebElement> addToCompareButtons;

    public CataloguePage(DriverWrapper driver) {
        super(driver);
        waitForMainElements();
    }

    @FindBy(xpath = ".//section[@class='catalog']")
    public WebElement catalogue;

    @FindBy(xpath = ".//a[@class='add-to-compare-link']")
    public List<WebElement> addToCompareButtonPath;

    @FindBy(xpath = ".//a[contains(@href, '/compare/')]")
    public WebElement compareButtonPath;

    @FindBy(xpath = ".//div[@class='content-shadow-block']//article")
    public List<WebElement> productsXpath;

    @FindBy(xpath = ".//input[@id='price-min']")
    public WebElement LOWPriceFilterField;

    @FindBy(xpath = ".//input[@id='price-max']")
    public WebElement HIGHPriceFilterField;

    @FindBy(xpath = ".//a[@id='buttonPrice']")
    public WebElement OKButtonPriceFilter;

    @FindBy(xpath = ".//div[contains(@class, 'container-filters')]")
    public WebElement filterBlock;

    @Override
    public void waitForMainElements() {
        driver.waitTillElementPresent(catalogue);
        driver.waitTillElementPresent(filterBlock);
    }

    @Override
    public CataloguePage openPage() {
        throw new UnsupportedOperationException("This page should not be loaded directly");
    }

    public void addProductsToComparing(Integer amount) {
        addToCompareButtons = addToCompareButtonPath;
        if (addToCompareButtons.size() >= amount) {
            driver.clickAllWhenReady(addToCompareButtons.subList(0, amount));
        } else {
            throw new NoSuchElementException(format("Amount of elements is less than %s", amount));
        }
    }
}
