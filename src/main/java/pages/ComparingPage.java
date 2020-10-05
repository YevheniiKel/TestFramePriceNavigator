package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparingPage extends BasePage {

    private static String comparingLink;

    public ComparingPage(WebDriver driver) {
        super(driver);
        waitForMainElements();
    }

    @FindBy(xpath = ".//a[@class='delete']")
    public List<WebElement> deleteButtons;

    @FindBy(xpath = ".//th[@class = 'item']")
    public List<WebElement> productsOnComparing;

    @FindBy(xpath = ".//a[@data-select-text='static-link']")
    public WebElement comparingLinkButton;

    @FindBy(xpath = ".//textarea[@id='static-link']")
    public WebElement comparingLinkField;

    @Override
    public void waitForMainElements() {
        wait.tillElementsPresent(productsOnComparing);
    }

    @Override
    public ComparingPage openPage() {
        throw new UnsupportedOperationException("This page should not be loaded directly");
    }
    public int amountOfComparingProducts() {
        wait.tillElementsPresent(productsOnComparing);
        return productsOnComparing.size();
    }
}
