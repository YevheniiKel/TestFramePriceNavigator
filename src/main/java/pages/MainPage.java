package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.CharDataForTestSite;

import java.util.List;

public class MainPage extends HeaderAnyPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[@class='pc-block']//a[@title]")
    public List<WebElement> subCategories;

    @Override
    public void waitForMainElements() {
        wait.tillElementsPresent(subCategories);
    }

    @Override
    public MainPage openPage() {
        driver.get(CharDataForTestSite.HOME_URL);
        waitForMainElements();
        return this;
    }

    public CataloguePage chooseAnySubCategory() {
        wait.tillElementsPresent(subCategories);
        subCategories.stream().findAny().get().click();
        return new CataloguePage(driver);
    }
}
