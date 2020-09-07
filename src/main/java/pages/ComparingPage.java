package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparingPage {
    private static String comparingLink;

    private WebDriver driver;

    public ComparingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By deleteButton = By.cssSelector(".delete");
    private By productsToCompare = By.className("item");
    private By comparingLinkButton = By.partialLinkText("Сформировать ссылку");
    private By comparingLinkField = By.id("static-link");

    public int amountOfComparingProducts() {
        return driver.findElements(productsToCompare).size();
    }

    public void deleteProductFromComparing() {
        driver.findElements(deleteButton).get(2).click();
    }

    public ComparingPage clickGenerateComparingLink() {
        driver.findElement(comparingLinkButton).click();
        return this;
    }

    public void setComparingLinkFromTheField() {
        comparingLink = driver.findElement(comparingLinkField).getText();
    }

    public static String getComparingLink() throws InterruptedException {
        return comparingLink;
    }
}
