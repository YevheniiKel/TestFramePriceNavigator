package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.CharDataForTestSite;
import util.driverUtils.DriverWrapper;

import java.util.List;

import static java.lang.String.format;

public class MainPage extends BasePage {

    public BaseHeader header;

    public MainPage(DriverWrapper driver) {
        super(driver);
        header = new BaseHeader(driver);
    }

    @FindBy(xpath = ".//div[@class='pc-block']//a[@title]")
    public List<WebElement> subCategories;

    @FindBy(xpath = ".//a[@href = '/electronics/']")
    public WebElement electronicsCategory;

    @FindBy(xpath = ".//a[contains(@class, 'pc-block__head')]")
    public List<WebElement> categories;

    @Override
    public void waitForMainElements() {
        driver.tillElementsPresent(categories);
    }

    @Override
    public MainPage openPage() {
        driver.get(CharDataForTestSite.HOME_URL);
        waitForMainElements();
        return this;
    }

    public CataloguePage chooseAnySubCategory() {
        driver.tillElementsPresent(subCategories);
        subCategories.stream().findAny().get().click();
        return new CataloguePage(driver);
    }

    public CataloguePage chooseSomeSubcategory(String subcategory) {
        driver.tillElementsPresent(subCategories);
        electronicsCategory.findElement(By.xpath(format("..//a[contains(@title, '%s')]", subcategory))).click();
        return new CataloguePage(driver);
    }
}
