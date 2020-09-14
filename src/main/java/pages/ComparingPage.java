package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparingPage extends BasePage {

    private static String comparingLink;

    public ComparingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//a[@class='delete']")
    List<WebElement> deleteButton;

    @FindBy(xpath = ".//th[@class = 'item']")
    List<WebElement> productsOnComparing;

    @FindBy(xpath = ".//a[@data-select-text='static-link']")
    WebElement comparingLinkButton;

    @FindBy(xpath = ".//textarea[@id='static-link']")
    WebElement comparingLinkField;

    public static String getComparingLink() {
        return comparingLink;
    }

    public int amountOfComparingProducts() {
        return productsOnComparing.size();
    }

    public void deleteProductFromComparing() {
        deleteButton.get(2).click();
    }

    public ComparingPage clickGenerateComparingLink() {
        comparingLinkButton.click();
        return this;
    }

    public void setComparingLinkFromTheField() {
        comparingLink = comparingLinkField.getText();
    }
}
