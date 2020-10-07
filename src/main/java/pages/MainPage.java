package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BaseHeader;
import pages.base.BasePage;
import utils.dataUtils.CharDataForTestSite;
import utils.driverUtils.DriverWrapper;

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

    @Override
    public void waitForMainElements() {
        driver.waitTillElementPresent(electronicsCategory);
    }

    @Override
    public MainPage openPage() {
        driver.get(CharDataForTestSite.HOME_URL);
        waitForMainElements();
        return this;
    }

    public CataloguePage chooseAnySubCategory() {
        driver.waitTillElementsPresent(subCategories);
        subCategories.stream().findAny().get().click();
        return new CataloguePage(driver);
    }

    public CataloguePage chooseSomeSubcategory(String subcategory) {
        driver.waitTillElementsPresent(subCategories);
        electronicsCategory.findElement(By.xpath(format("..//a[contains(@title, '%s')]", subcategory))).click();
        return new CataloguePage(driver);
    }
}
