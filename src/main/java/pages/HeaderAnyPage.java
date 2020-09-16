package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderAnyPage extends BasePage {

    public HeaderAnyPage(WebDriver driver) {
        super(driver);
        wait.waitMainElementAppear(searchField);
    }

    @FindBy(xpath = ".//input[@class = 'search-text-input']")
    public WebElement searchField;

    @FindBy(xpath = ".//div[@class='no-block']")
    public WebElement nothingToSHowInCatalogue;

    @FindBy(xpath = ".//div[@class='search-info']")
    public WebElement nothingToSHowInSearchResult;

    public HeaderAnyPage enterSearchQuery(String searchQuery) {
        wait.sendKeysWhenReadyThenEnter(searchField, searchQuery);
        return this;
    }
}
