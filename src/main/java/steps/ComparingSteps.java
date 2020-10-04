package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.MainPage;
import util.driverUtils.DriverProvider;
import util.elementUtils.WaitUtils;

public class ComparingSteps {
    private DriverProvider driverProvider;
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private ComparingPage comparingPage;
    private WaitUtils wait;

    int amountOfComparingProducts;

    public ComparingSteps(DriverProvider driverProvider) {
        this.driverProvider = driverProvider;
        wait = new WaitUtils(driverProvider.getDriver());
        mainPage = new MainPage(driverProvider.getDriver());
    }

    @And("User add {string} products to comparing")
    public void userAddProductsToComparing(String amount) {
        cataloguePage.addProductsToComparing(Integer.parseInt(amount));
    }

    @And("Clicks Compare button")
    public void clicksCompareButton() {
        wait.clickWhenReady(cataloguePage.compareButtonPath);
        comparingPage = new ComparingPage(driverProvider.getDriver());
    }

    @And("User put this link into address bar and press enter")
    public void userPutThisLinkIntoAddressBarAndPressEnter() {
        driverProvider.getDriver().get(ComparingPage.getComparingLink());
    }

    @When("One product has been deleted from the comparing")
    public void oneProductHasBeenDeletedFromTheComparing() {
        wait.clickElementFromList(comparingPage.deleteButtons,2);
    }

    @When("Generate a Link button is clicked and popup with link appear")
    public void generateALinkButtonIsClickedAndPopupWithLinkAppear() {
        amountOfComparingProducts = Integer.parseInt(comparingPage.amountOfComparingProducts());
        wait.clickWhenReady(comparingPage.comparingLinkButton);
        comparingPage.setComparingLinkFromTheField();
    }

    @Then("User is navigated on the same comparing page")
    public void userIsNavigatedOnTheSameComparingPage() {
        ComparingPage newComparingPage = new ComparingPage(driverProvider.getDriver());
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
