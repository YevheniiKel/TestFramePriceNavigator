package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.CharDataForTestSite;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        waitForMainElements();
    }

    @FindBy(xpath = ".//div[@class='pc-block']//a[@title]")
    public List<WebElement> subCategories;

    @Override
    public void waitForMainElements() {
        wait.tillElementsPresent(subCategories);
    }

    @Override
    public void openPage(WebDriver driver) {
        driver.get(CharDataForTestSite.HOME_URL);
    }


    public CataloguePage chooseAnySubCategory() {
        wait.tillElementsPresent(subCategories);
        subCategories.stream().findAny().get().click();
        return new CataloguePage(driver);
    }
}
