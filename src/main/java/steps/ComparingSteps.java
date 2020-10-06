package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.ComparingPage;
import util.driverUtils.DriverProvider;
import util.driverUtils.DriverWrapper;

public class ComparingSteps {

    private DriverWrapper driver;
    private ComparingPage comparingPage;

    private int amountOfComparingProducts;
    private String comparingLink;

    public ComparingSteps(DriverProvider driver) {
        this.driver = driver.getDriver();
    }

    @When("One product has been deleted from the comparing")
    public void oneProductHasBeenDeletedFromTheComparing() {
        comparingPage = new ComparingPage(driver);
        driver.clickElementFromList(comparingPage.deleteButtons, 2);
    }

    @When("Generate a Link button is clicked and popup with link appear")
    public void generateALinkButtonIsClickedAndPopupWithLinkAppear() {
        comparingPage = new ComparingPage(driver);
        amountOfComparingProducts = comparingPage.amountOfComparingProducts();
        driver.clickWhenReady(comparingPage.comparingLinkButton);
        driver.waitTillElementContainAnyText(comparingPage.comparingLinkField);
        comparingLink = comparingPage.comparingLinkField.getText();
    }

    @And("User follows with generated link")
    public void userPutThisLinkIntoAddressBarAndPressEnter() {
        driver.get(comparingLink);
    }

    @Then("User is navigated to the same comparing page")
    public void userIsNavigatedOnTheSameComparingPage() {
        ComparingPage newComparingPage = new ComparingPage(driver);
        Assertions.assertThat(newComparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount = %s.\n",
                        comparingPage.amountOfComparingProducts(), amountOfComparingProducts))
                .isEqualTo(amountOfComparingProducts);
    }

    @Then("Amount of comparing products should be equal {string}")
    public void amountOfComparingProductsShouldBeEqual(String amount) {
        comparingPage = new ComparingPage(driver);
        Assertions.assertThat(comparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), amount))
                .isEqualByComparingTo(Integer.parseInt(amount));
    }
}
