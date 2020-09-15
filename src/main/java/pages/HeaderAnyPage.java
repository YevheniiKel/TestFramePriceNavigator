package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.elementUtils.WaitUtils;

public class HeaderAnyPage extends BasePage {

    public HeaderAnyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@class = 'search-text-input']")
    public WebElement searchField;

    @FindBy(xpath = ".//div[@class='no-block']")
    public WebElement nothingToSHowInCatalogue;

    @FindBy(xpath = ".//div[@class='search-info']")
    public WebElement nothingToSHowInSearchResult;

    public HeaderAnyPage enterSearchQuery(String searchQuery) throws InterruptedException {
        searchField.sendKeys(searchQuery, Keys.ENTER);
        WaitUtils.sleepSeconds(3);
        return this;
    }
}
