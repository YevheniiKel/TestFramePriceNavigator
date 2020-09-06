package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Const;
import util.UtilSleep;

import java.util.List;
import java.util.stream.Stream;

public class HeaderPageFactory {

    private WebDriver driver;

    private By searchField = By.className("search-text-input");
    private By searchResultList = By.className("search-tips-body");

    public HeaderPageFactory(WebDriver driver){
        this.driver = driver;
    }

    private void chooseOneSpecificProductFromTheList(){
        driver.findElements(searchResultList)
                .stream().findFirst().get().click();
    }

    public HeaderPageFactory enterSearchQueryIntoSearchField(String searchQuery) throws InterruptedException {
        driver.findElement(searchField).sendKeys(
                Const.CATEGORIES
                        .stream()
                        .findAny()
                        .get());

        UtilSleep.sleep();
        return this;
    }

}
