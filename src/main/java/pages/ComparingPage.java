package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.CharDataForTestSite;

import java.util.List;

public class ComparingPage extends BasePage {

    private static String comparingLink;

    public ComparingPage(WebDriver driver) {
        super(driver);
        openPage();
    }

    @FindBy(xpath = ".//a[@class='delete']")
    List<WebElement> deleteButton;

    @FindBy(xpath = ".//th[@class = 'item']")
    List<WebElement> productsOnComparing;

    @FindBy(xpath = ".//a[@data-select-text='static-link']")
    WebElement comparingLinkButton;

    @FindBy(xpath = ".//textarea[@id='static-link']")
    WebElement comparingLinkField;

    @Override
    public void waitForMainElements() {
        wait.tillElementsPresent(productsOnComparing);
    }

    @Override
    public ComparingPage openPage() {
        driver.get(CharDataForTestSite.HOME_URL);
        MainPage mainPage = new MainPage(driver);
        CataloguePage cataloguePage = mainPage.chooseAnySubCategory();
        cataloguePage.addThreeProductsToComparing();
        cataloguePage.clickCompare();
        return new ComparingPage(driver);
    }

    public static String getComparingLink() {
        return comparingLink;
    }

    public int amountOfComparingProducts() {
        wait.tillElementsPresent(productsOnComparing);
        return productsOnComparing.size();
    }

    public void deleteProductFromComparing() {
        wait.clickWhenReady(deleteButton.get(2));
    }

    public ComparingPage clickGenerateComparingLink() {
        wait.clickWhenReady(comparingLinkButton);
        return this;
    }

    public void setComparingLinkFromTheField() {
        wait.tillElementContainAnyText(comparingLinkField);
        comparingLink = comparingLinkField.getText();
    }
}
