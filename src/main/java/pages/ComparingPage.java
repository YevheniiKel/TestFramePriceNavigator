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

    @FindBy(css = ".delete")
    List<WebElement> deleteButton;

    @FindBy(className = "item")
    List<WebElement> productsToCompare;

    @FindBy(partialLinkText = "Сформировать ссылку")
    WebElement comparingLinkButton;

    @FindBy(id = "static-link")
    WebElement comparingLinkField;

    public static String getComparingLink() {
        return comparingLink;
    }

    public int amountOfComparingProducts() {
        return productsToCompare.size();
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
