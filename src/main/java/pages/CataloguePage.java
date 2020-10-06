package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.driverUtils.DriverWrapper;

import java.util.List;

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

    @FindBy(xpath = ".//li[contains(@class,'dropdown-sorting')]/a")
    public WebElement sortDropDown;

    @FindBy(xpath = ".//a[@data-sort='price']")
    public WebElement sortLowToHigh;

    @FindBy(xpath = ".//a[@data-sort='price_desc']")
    public WebElement sortHighToLow;

    @FindBy(xpath = ".//div[@class='catalog-block-head']//a")
    public WebElement productNamePath;

    @FindBy(xpath = ".//a[@class='price']//span")
    public WebElement productPricePath;

    @FindBy(xpath = ".//a[@class='price']//span/../strong[1]")
    public WebElement productLOWPricePath;

    @FindBy(xpath = ".//p[@class='content-item']//a")
    public WebElement productDescriptionPath;

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
        int i = amount;
        addToCompareButtons = addToCompareButtonPath;
        if (addToCompareButtons.size() >= i) {
            driver.clickAllWhenReady(addToCompareButtons.subList(0, i));
        } else {
            throw new NoSuchElementException("Amount of elements is less than 3");
        }
    }
}
