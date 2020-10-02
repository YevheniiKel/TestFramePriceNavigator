package pages;

import dto.ProductDto;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CataloguePage extends HeaderAnyPage {

    public List<WebElement> addToCompareButtons;

    public CataloguePage(WebDriver driver) {
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

    @FindBy(xpath = ".//div[@class='filter']")
    public WebElement filters;

    @FindBy(xpath = ".//input[@id='price-min']")
    public WebElement LOWPriceFilterField;

    @FindBy(xpath = ".//input[@id='price-max']")
    public WebElement HIGHPriceFilterField;

    @FindBy(xpath = ".//a[@id='buttonPrice']")
    public WebElement OKButtonPriceFilter;

    @FindBy(xpath = ".//div[@id = 'producers-filter-block']")
    public WebElement manufactureFilterBlock;

    @FindBy(xpath = ".//div[@class='filter-block-body']")
    public WebElement yearFilterBlock;

    @FindBy(xpath = ".//li[contains(@class,'dropdown-sorting')]/a")
    public WebElement sortDropDown;

    @FindBy(xpath = ".//a[@data-sort='price']")
    public WebElement sortLowToHigh;

    @FindBy(xpath = ".//a[@data-sort='price_desc']")
    public WebElement sortHighToLow;

    @FindBy(xpath = ".//div[@class='catalog-block-head']//a")
    public By productNamePath;

    @FindBy(xpath = ".//a[@class='price']//span")
    public By productPricePath;

    @FindBy(xpath = ".//a[@class='price']//span/../strong[1]")
    public By productLOWPricePath;

    @FindBy(xpath = ".//p[@class='content-item']//a")
    public By productDescriptionPath;

    @Override
    public void waitForMainElements() {
        wait.tillElementPresent(catalogue);
        wait.tillElementPresent(filters);
    }

    @Override
    public CataloguePage openPage() {
        throw new UnsupportedOperationException("This page should not be loaded directly");
    }

    public void addProductsToComparing(Integer amount) {
        addToCompareButtons = addToCompareButtonPath;
        if (addToCompareButtons.size() >= amount) {
            wait.clickAllWhenReady(addToCompareButtons.subList(0, amount));
        } else {
            throw new NoSuchElementException("Amount of elements is less than 3");
        }
    }

//    public void filtersByPrice(int low, int high) {
//        LOWPriceFilterField.sendKeys(String.valueOf(low));
//        HIGHPriceFilterField.sendKeys(String.valueOf(high));
//        OKButtonPriceFilter.click();
//        wait.tillElementInvisible(catalogue.findElement(By.xpath(".//div[contains(@class, 'on-loading')]")));
//        updateProductList();
//    }
//
//    public void filterByMaxPrice(int high) {
//        HIGHPriceFilterField.sendKeys(String.valueOf(high));
//        OKButtonPriceFilter.click();
//        updateProductList();
//    }
//
//    public void sortByPriceLowToHigh() {
//        wait.clickWhenReady(sortDropDown);
//        wait.clickWhenReady(sortLowToHigh);
//        updateProductList();
//    }
//
//    public void sortByPriceHighToLow() {
//        wait.clickWhenReady(sortDropDown);
//        wait.clickWhenReady(sortHighToLow);
//        updateProductList();
//    }
//
//    public boolean productsShownWithPricesLOW_HIGH(int low, int high) {
//
//        return productsDto.isEmpty()
//                || ProductDto.getLowestPrice(productsDto) >= low
//                && ProductDto.getHighestPrice(productsDto) <= high;
//    }
//
//    public boolean productsDisplayedWithPriceMoreThan(int low) {
//        for (ProductDto p : productsDto) {
//            if ((p.getLowestPrice() <= low))
//                return false;
//        }
//        return true;
//    }
//
//    public boolean productsDisplayedWithPriceLessThan(int high) {
//        for (ProductDto p :
//                productsDto) {
//            if ((p.getLowestPrice() >= high))
//                return false;
//        }
//        return true;
//    }
//
//    public boolean filtrationByPriceIsAvailable() {
//        return LOWPriceFilterField.isDisplayed()
//                && HIGHPriceFilterField.isDisplayed()
//                && OKButtonPriceFilter.isDisplayed();
//    }
//
//    public boolean allProductsFromOneManufactureDisplayed(String man) {
//        for (ProductDto p :
//                productsDto) {
//            if (!p.getName().contains(man))
//                return false;
//        }
//        return true;
//    }
//
//    public boolean allProductsFromYearDisplayed(String year) {
//        for (ProductDto p :
//                productsDto) {
//            if (!p.getDescription().contains(year))
//                return false;
//        }
//        return true;
//    }
//
//    public boolean productsSortedLowToHigh() {
//        Comparator<ProductDto> compareByPrice = Comparator.comparing((ProductDto pr) -> pr.getLowestPrice());
//        List<ProductDto> testSortedList = productsDto.stream()
//                .sorted(compareByPrice).collect(Collectors.toList());
//        return testSortedList.equals(productsDto);
//    }
//
//    public boolean productsSortedHighToLow() {
//        Comparator<ProductDto> compareByPrice = (ProductDto pr1, ProductDto pr2) -> pr2.getLowestPrice().compareTo(pr1.getLowestPrice());
//        List<ProductDto> testSortedList = productsDto.stream()
//                .sorted(compareByPrice).collect(Collectors.toList());
//        return testSortedList.equals(productsDto);
//    }
}
