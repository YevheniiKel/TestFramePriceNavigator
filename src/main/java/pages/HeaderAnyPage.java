package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.elementUtils.UtilActionsWithElements;
import util.elementUtils.WaitUtils;

public class HeaderAnyPage extends BasePage {

    public HeaderAnyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class = 'search-text-input']")
    public WebElement searchField;

    @FindBy(xpath = "//div[@class='no-block']")
    WebElement nothingToSHowInCatalogue;

    @FindBy(xpath = "//div[@class='search-info']")
    WebElement nothingToSHowInSearchResult;

    public HeaderAnyPage enterSearchQuery(String searchQuery) throws InterruptedException {
        searchField.sendKeys(searchQuery, Keys.ENTER);
        WaitUtils.sleepSeconds(3);
        return this;
    }

    public boolean isProductNotFountNotificationIsShown() throws InterruptedException { //todo make separated test cases, redesign tests with dataProvider
        WaitUtils.sleepSeconds(1);
        return UtilActionsWithElements.isElementDisplayed(nothingToSHowInCatalogue)
                ||
                UtilActionsWithElements.isElementDisplayed(nothingToSHowInSearchResult);
    }
}
