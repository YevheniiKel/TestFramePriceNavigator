package steps;

import io.cucumber.java.en.Then;
import pages.MainPage;
import util.driverUtils.DriverProvider;
import util.elementUtils.WaitUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationSteps {
    private MainPage mainPage;
    private WaitUtils wait;


    public LocalizationSteps(DriverProvider driverProvider) {
        wait = new WaitUtils(driverProvider.getDriver());
        mainPage = new MainPage(driverProvider.getDriver());
    }

    @Then("The search city is Kharkiv")
    public void theSearchCityIsKharkiv() {
        assertThat(mainPage.searchField.getAttribute("placeholder"))
                .as(String.format("The placeholder text is incorrect: %s", "Найти товар в Харькове"))
                .contains("Найти товар в Харькове")
                .doesNotContain("Киев")
                .doesNotContain("Винница");
    }
}
