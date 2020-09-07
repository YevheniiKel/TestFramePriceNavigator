package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    private String shopName;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private By IntoShopButton = By.className("form-btn form-btn--yellow price-click");


    public ProductPage getInformationAboutOneShop() {

    return this;
    }
}
