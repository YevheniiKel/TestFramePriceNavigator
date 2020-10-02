package steps;

import dto.ProductDto;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CataloguePage;
import util.DriverManager;
import util.elementUtils.WaitUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static util.BrowserFactory.getDriver;
import static util.elementUtils.UtilElements.parseLowestPrice;

public class CatalogueSteps {
    private CataloguePage cataloguePage;
    private WaitUtils wait;
    DriverManager driverManager;
    private List<ProductDto> products = new ArrayList<ProductDto>();


    public CatalogueSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WaitUtils(driverManager.getDriver());
    }

    @Then("Catalogue is displayed")
    public void catalogueIsDisplayed() {
        assertThat(
                wait
                        .isElementDisplayed(
                                cataloguePage.catalogue))
                .as("Catalogue is not displayed on the catalogue page")
                .isTrue();
    }

    @When("User filter products by price in range from {int} to {int}")
    public void userFilterProductsByPriceInRangeFromLowToHigh(int low, int high) {
        cataloguePage = new CataloguePage(driverManager.getDriver());
        cataloguePage.LOWPriceFilterField.sendKeys(String.valueOf(low));
        cataloguePage.HIGHPriceFilterField.sendKeys(String.valueOf(high));
        cataloguePage.OKButtonPriceFilter.click();
        wait.tillElementInvisible(cataloguePage.catalogue.findElement(By.xpath(".//div[contains(@class, 'on-loading')]")));
        updateProductList();
    }

    @Then("Only products with a price in range from {int} to {int} are shown")
    public void onlyProductsWithAPriceInRangeFromLowToHighAreShown(int low, int high) {
        assertThat(
                products.isEmpty()
                        || ProductDto.getLowestPrice(products) >= low
                        && ProductDto.getHighestPrice(products) <= high)
                .isTrue();
    }

    @When("User using filter to see the products with price more than {int}")
    public void userUsingFilterToSeeTheProductsWithPriceMoreThanLow(int low) {
        cataloguePage.LOWPriceFilterField.sendKeys(String.valueOf(low));
        cataloguePage.OKButtonPriceFilter.click();
        updateProductList();
    }

    @Then("Only products with a price  more than {int} are shown")
    public void onlyProductsWithAPriceMoreThanLowAreShown(int low) {
        assertThat(products.stream().allMatch(productDto -> (productDto.getLowestPrice() >= low)));

    }

    @When("User using filter to see the products with price less than {int}")
    public void userUsingFilterToSeeTheProductsWithPriceLessThanHigh(int high) {
        cataloguePage.HIGHPriceFilterField.sendKeys(String.valueOf(high));
        cataloguePage.OKButtonPriceFilter.click();
        updateProductList();
    }

    @Then("Only products with a price less than {int} are shown")
    public void onlyProductsWithAPriceLessThanHighAreShown(int high) {
        assertThat(products.stream().allMatch(productDto -> (productDto.getLowestPrice() <= high)));

    }

    @When("User using filter to see the products that created by {string}")
    public void userUsingFilterToSeeTheProductsThatCreatedByManufacture(String manufacture) {
        wait.clickWhenReady(cataloguePage.manufactureFilterBlock
                .findElement(By.xpath(String.format(".//a[contains(text(),'%s')]", manufacture))));
        updateProductList();
    }

    @Then("Only products with that created by {string} are shown")
    public void onlyProductsWithThatCreatedByManufactureAreShown(String year) {
        wait.clickWhenReady(cataloguePage.yearFilterBlock
                .findElement(By.xpath(String.format(".//a[contains(text(),'%s')]", year))));
        updateProductList();
    }

    private void updateProductList() {
        products.clear();
        cataloguePage = new CataloguePage(driverManager.getDriver());
        for (WebElement pr : cataloguePage.productsXpath) {
            products.add(new ProductDto()
                    .setName(pr.findElement(cataloguePage.productNamePath).getText())
                    .setLowestPrice(parseLowestPrice(pr.findElement(cataloguePage.productLOWPricePath)))
                    .setDescription(pr.findElement(cataloguePage.productDescriptionPath).getText())
            );
        }
    }
}
