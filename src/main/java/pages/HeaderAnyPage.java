package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.elementUtils.UtilActionsWithElements;
import util.elementUtils.WaitUtils;

public class HeaderAnyPage {

    private WebDriver driver;

    @FindBy(className = "search-text-input")
    WebElement searchField;

    @FindBy(className = "search-tips-body")
    WebElement searchResultList;

    @FindBy(xpath = "//div[@class='no-block']")
    WebElement nothingToSHowInCatalogue;

    @FindBy(xpath = "//div[@class='search-info']")
    WebElement nothingToSHowInSearchResult;

    public HeaderAnyPage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderAnyPage enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) throws InterruptedException {
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.ENTER);
        WaitUtils.sleepSeconds(3);
        return this;
    }

    public boolean isProductNotFountNotificationIsShown() { //todo make separated test cases, redesign tests with dataProvider
        return UtilActionsWithElements.isElementDisplayed(driver, nothingToSHowInCatalogue)
                ||
                UtilActionsWithElements.isElementDisplayed(driver, nothingToSHowInSearchResult);
    }
}
