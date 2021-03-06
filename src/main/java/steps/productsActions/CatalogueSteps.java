package steps.productsActions;

import dto.ProductDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CataloguePage;
import utils.driverUtils.DriverProvider;
import utils.driverUtils.DriverWrapper;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.elementUtils.UtilElements.parseLowestPrice;

public class CatalogueSteps {

    private DriverWrapper driver;

    private List<ProductDto> products;

    public CatalogueSteps(DriverProvider driver) {
        this.driver = driver.getDriver();
        products = new ArrayList<>();
    }

    @When("User adds {int} products to comparing")
    public void userAddProductsToComparing(int amount) {
        var cataloguePage = new CataloguePage(driver);
        cataloguePage.addProductsToComparing(amount);
    }

    @And("User clicks Compare button")
    public void clicksCompareButton() {
        var cataloguePage = new CataloguePage(driver);
        driver.clickWhenReady(cataloguePage.compareButtonPath);
    }

    @When("User applies filter by price in range from {int} to {int}")
    public void userFilterProductsByPriceInRangeFromLowToHigh(int low, int high) {
        var cataloguePage = new CataloguePage(driver);
        driver.sendKeysWhenReady(cataloguePage.LOWPriceFilterField, String.valueOf(low));
        driver.sendKeysWhenReady(cataloguePage.HIGHPriceFilterField, String.valueOf(high));
        driver.clickWhenReady(cataloguePage.OKButtonPriceFilter);
        updateProductList();
    }

    @Then("Catalogue page is displayed")
    public void catalogueIsDisplayed() {
        var cataloguePage = new CataloguePage(driver);
        assertThat(driver.isElementDisplayed(cataloguePage.catalogue))
                .as("Catalogue is not displayed on the catalogue page")
                .isTrue();
    }

    @Then("Products with a price in range from {int} to {int} are shown")
    public void onlyProductsWithAPriceInRangeFromLowToHighAreShown(int low, int high) {
        new CataloguePage(driver);
        assertThat(products.stream().allMatch(productDto ->
                ((productDto.getLowestPrice() >= low) && (productDto.getLowestPrice() <= high))));
    }

    @When("User applies filter by price more than {int}")
    public void userUsingFilterToSeeTheProductsWithPriceMoreThanLow(int low) {
        var cataloguePage = new CataloguePage(driver);
        driver.sendKeysWhenReady(cataloguePage.LOWPriceFilterField, String.valueOf(low));
        driver.clickWhenReady(cataloguePage.OKButtonPriceFilter);
        updateProductList();
    }

    @Then("Products with a price more than {int} are shown")
    public void onlyProductsWithAPriceMoreThanLowAreShown(int low) {
        new CataloguePage(driver);
        assertThat(products.stream().allMatch(productDto -> (productDto.getLowestPrice() >= low)));

    }

    @When("User applies filter by price less than {int}")
    public void userUsingFilterToSeeTheProductsWithPriceLessThanHigh(int high) {
        var cataloguePage = new CataloguePage(driver);
        driver.sendKeysWhenReady(cataloguePage.HIGHPriceFilterField, String.valueOf(high));
        driver.clickWhenReady(cataloguePage.OKButtonPriceFilter);
        updateProductList();
    }

    @Then("Products with a price less than {int} are shown")
    public void onlyProductsWithAPriceLessThanHighAreShown(int high) {
        new CataloguePage(driver);
        assertThat(products.stream().allMatch(productDto -> (productDto.getLowestPrice() <= high)));

    }

    @When("User applies filter by manufacture: {string}")
    public void filterByManufacture(String manufacture) {
        var cataloguePage = new CataloguePage(driver);
        driver.clickWhenReady(cataloguePage.filterBlock
                .findElement(By.xpath(String.format(".//a[contains(text(),'%s') and @data-id]", manufacture))));
        updateProductList();
    }

    @When("User applies filer by year {string}")
    public void filterByYear(String year) {
        var cataloguePage = new CataloguePage(driver);
        driver.clickWhenReady(cataloguePage.filterBlock
                .findElement(By.xpath(String.format(".//a[contains(text(),'%s') and @data-id]", year))));
        updateProductList();
    }

    @Then("Products created by {string} are shown")
    public void onlyProductsWithThatCreatedByManufactureAreShown(String manufacture) {
        assertThat(products.stream().allMatch(productDto -> (productDto.getName().contains(manufacture))));

    }

    @Then("Products from {string} are shown")
    public void productsFromSomeYearAreShown(String year) {
        assertThat(products.stream().allMatch(productDto -> (productDto.getDescription().contains(year))));

    }

    private void updateProductList() {
        var cataloguePage = new CataloguePage(driver);
        products.clear();
        for (WebElement pr : cataloguePage.productsXpath) {
            products.add(new ProductDto()
                    .setName(pr.findElement(By.xpath("//div[@class='catalog-block-head']//a")).getText())
                    .setLowestPrice(parseLowestPrice(pr.findElement(By.xpath(".//a[@class='price']//span/../strong[1]"))))
                    .setDescription(pr.findElement(By.xpath(".//p[@class='content-item']//a")).getText())
            );
        }
    }
}

