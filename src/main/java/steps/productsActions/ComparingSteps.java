package steps.productsActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.ComparingPage;
import utils.driverUtils.DriverProvider;
import utils.driverUtils.DriverWrapper;

public class ComparingSteps {

    private DriverWrapper driver;

    private int amountOfComparingProducts;
    private String comparingLink;

    public ComparingSteps(DriverProvider driver) {
        this.driver = driver.getDriver();
    }

    @When("One product has been deleted from the comparing")
    public void oneProductHasBeenDeletedFromTheComparing() {
        var comparingPage = new ComparingPage(driver);
        driver.clickElementFromList(comparingPage.deleteButtons, 2);
    }

    @When("Generate a Link button is clicked and popup with link appear")
    public void generateALinkButtonIsClickedAndPopupWithLinkAppear() {
        var comparingPage = new ComparingPage(driver);
        amountOfComparingProducts = comparingPage.amountOfComparingProducts();
        driver.clickWhenReady(comparingPage.comparingLinkButton);
        driver.waitTillElementContainAnyText(comparingPage.comparingLinkField);
        comparingLink = comparingPage.comparingLinkField.getText();
    }

    @And("User follows with generated link")
    public void userPutThisLinkIntoAddressBarAndPressEnter() {
        if (!comparingLink.isEmpty()) driver.get(comparingLink);
        else throw new IllegalArgumentException("Link is not generated");
    }

    @Then("User is navigated to the same comparing page")
    public void userIsNavigatedOnTheSameComparingPage() {
        var newComparingPage = new ComparingPage(driver);
        Assertions.assertThat(newComparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount = %s.\n",
                        newComparingPage.amountOfComparingProducts(), amountOfComparingProducts))
                .isEqualTo(amountOfComparingProducts);
    }

    @Then("Amount of comparing products should be equal {string}")
    public void amountOfComparingProductsShouldBeEqual(String amount) {
        var comparingPage = new ComparingPage(driver);
        Assertions.assertThat(comparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), amount))
                .isEqualByComparingTo(Integer.parseInt(amount));
    }
}
