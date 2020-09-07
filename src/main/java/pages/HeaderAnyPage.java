package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import util.UtilActionsWithElements;
import util.UtilSleep;

public class HeaderAnyPage {

    private WebDriver driver;

    private By searchField = By.className("search-text-input");
    private By searchResultList = By.className("search-tips-body");

    private By nothingToSHowInCatalogue = By.xpath("//div[@class='no-block']");
    private By nothingToSHowInSearchResult = By.xpath("//div[@class='search-info']");

    public HeaderAnyPage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderAnyPage enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) throws InterruptedException {
        driver.findElement(searchField).sendKeys(searchQuery);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        UtilSleep.sleep();
        return this;
    }

    public boolean isProductNotFountNotificationIsShown() {
        return UtilActionsWithElements.isElementDisplayed(driver, nothingToSHowInCatalogue)
                ||
                UtilActionsWithElements.isElementDisplayed(driver, nothingToSHowInSearchResult);
    }
}
