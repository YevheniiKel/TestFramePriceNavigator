package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.MainPage;

public class ComparingTestSteps {
    private DriverManager driverManager;
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private ComparingPage comparingPage;

    int amountOfComparingProducts;

    public ComparingTestSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
        mainPage = new MainPage(driverManager.getDriver());
    }

    @And("User opens some subcategory")
    public void userOpensSomeCategory() {
        cataloguePage = mainPage.chooseAnySubCategory();
    }

    @And("User add {string} products to comparing")
    public void userAddProductsToComparing(String amount) {
        cataloguePage.addProductsToComparing(Integer.parseInt(amount));
    }

    @And("Clicks Compare button")
    public void clicksCompareButton() {
        comparingPage = cataloguePage.clickCompare();
    }

    @And("User put this link into address bar and press enter")
    public void userPutThisLinkIntoAddressBarAndPressEnter() {
        driverManager.getDriver().get(ComparingPage.getComparingLink());

    }

    @When("One product has been deleted from the comparing")
    public void oneProductHasBeenDeletedFromTheComparing() {
        comparingPage.deleteOneProductFromComparing();
    }

    @When("Generate a Link button is clicked and popup with link appear")
    public void generateALinkButtonIsClickedAndPopupWithLinkAppear() {
        amountOfComparingProducts = Integer.parseInt(comparingPage.amountOfComparingProducts());
        comparingPage.clickGenerateComparingLink();
        comparingPage.setComparingLinkFromTheField();
    }

    @Then("User is navigated on the same comparing page")
    public void userIsNavigatedOnTheSameComparingPage() {
        ComparingPage newComparingPage = new ComparingPage(driverManager.getDriver());
        Assertions.assertThat(newComparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount = %s.\n",
                        comparingPage.amountOfComparingProducts(), amountOfComparingProducts))
                .isEqualTo(String.valueOf(amountOfComparingProducts));
    }

    @Then("Amount of comparing products should be equal {string}")
    public void amountOfComparingProductsShouldBeEqual(String amount) {
        Assertions.assertThat(comparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), amount))
                .isEqualTo(amount);
    }


}
