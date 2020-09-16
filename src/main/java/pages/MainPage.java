package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = ".//div[@class='pc-block']//a[@title]")
    public List<WebElement> subCategories;

    //todo iselemtainTExt(login) return bool

    public CataloguePage chooseAnySubCategory() {
        wait.tillElementsPresent(subCategories);
        subCategories.stream().findAny().get().click();
        return new CataloguePage(driver);
    }
}
