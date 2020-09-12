package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[contains(@class, 'average-price')]")
    WebElement avgPrice;

    @FindBy(xpath = ".//li[@itemprop='itemListElement'][last()]//span")
    WebElement manufactureName;

    @FindBy(xpath = ".//div[@class='popular-products opened']//li[last()]")
    WebElement lastPopularModel;

    @FindBy(xpath = ".//div[contains(@class, 'compare-links')]")
    WebElement compareLinksBlock;

    @FindBy(xpath = ".//following-sibling::span[starts-with(@class,'logo-')]")
    WebElement chooseCityButton;

    @FindBy(xpath = ".//div[@id='average-price']//span[not(contains(@class, 'big'))]")
    WebElement arrow;

    @FindBy(xpath = ".//ul[@class='nav-tabs']//li[contains(@class, 'active') or @class='map']")
    WebElement navtab;

    @FindBy(xpath = ".//*[@class='green' or contains(@class, 'icon-money')]")
    WebElement shopPaymentFeature;

    @FindBy(xpath = ".//span[@class='priceline-payment' and @data-toggle='dropdown']//")
    WebElement shopFeature;

    @FindBy(xpath = ".//a[@class= 'add-to-compare-link']/ancestor::*//a[@class='index']")
    WebElement descriptionAndPriceButton;

    @FindBy(xpath = ".//div[@class= 'product-price']//preceding-sibling::span")
    WebElement productPrices;

    @FindBy(xpath = ".//tbody[count(tr)=18]")
    WebElement mainDescriptionWith18characteristics;

    @FindBy(xpath = ".//tbody//tr[position()=76 mod 70]")
    WebElement get8thCharacteristic;

    @FindBy(xpath = ".//div[@class='td-row product-price-row']//div[position() > 3]")
    WebElement priceBlock;

    @FindBy(xpath = ".//tbody//td[@class='pb-bc-r-left'] | .//tbody//td[@class='pb-bc-r-right']")
    WebElement productCharacteristics;
}
