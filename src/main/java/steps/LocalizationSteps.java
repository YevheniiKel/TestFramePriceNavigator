package steps;

import io.cucumber.java.en.Then;
import pages.MainPage;
import utils.driverUtils.DriverProvider;
import utils.driverUtils.DriverWrapper;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationSteps {

    private DriverWrapper driver;

    public LocalizationSteps(DriverProvider driver) {
        this.driver = driver.getDriver();
    }

    @Then("The search city is Kharkiv")
    public void theSearchCityIsKharkiv() {
        var mainPage = new MainPage(driver);
        assertThat(mainPage.header.searchField.getAttribute("placeholder"))
                .as(String.format("The placeholder text is incorrect: %s", "Найти товар в Харькове"))
                .contains("Найти товар в Харькове")
                .doesNotContain("Киев")
                .doesNotContain("Винница");
    }
}
