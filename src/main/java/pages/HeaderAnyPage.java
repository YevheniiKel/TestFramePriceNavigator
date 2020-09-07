package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import util.Const;
import util.UtilSleep;

public class HeaderAnyPage {

    private WebDriver driver;

    private By searchField = By.className("search-text-input");
    private By searchResultList = By.className("search-tips-body");
    private By productNotFoundInCatalougeFormatDiv = By.xpath("//div[@class='h2']");
    private By productNotFoundInSearchFormatDiv = By.xpath("//div[@class='search-info-head']");


    public HeaderAnyPage(WebDriver driver){
        this.driver = driver;
    }

    public HeaderAnyPage enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) throws InterruptedException {
        driver.findElement(searchField).sendKeys(searchQuery);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        UtilSleep.sleep();
        return this;
    }

    public boolean isProductNotFountNotificationIsShown(){
        try {
           return driver.findElement(productNotFoundInCatalougeFormatDiv)
                    .getText().toLowerCase()
                   .contains(Const.PRODUCT_NOT_FOUND_NOTIFICATION.toLowerCase());
        }catch (NoSuchElementException e1){
            System.out.println();
            try{
                return driver.findElement(productNotFoundInSearchFormatDiv)
                        .getText().toLowerCase()
                        .contains(Const.NOTHING_FOUND_NOTIFICATION.toLowerCase());
            }catch (NoSuchElementException e2){
                return false;
            }
        }
    }
}
