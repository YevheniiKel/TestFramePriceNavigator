package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.MainPage;
import utils.driverUtils.DriverProvider;
import utils.driverUtils.DriverWrapper;

public class NavigationSteps {

    private DriverWrapper driver;

    public NavigationSteps(DriverProvider driver) {
        this.driver = driver.getDriver();
    }

    @Given("User opens main page")
    public void userOnTheMainPage() {
        new MainPage(driver).openPage();
    }

    @And("User opens some subcategory")
    public void userOpensSomeCategory() {
        new MainPage(driver).chooseAnySubCategory();
    }

    @And("User opens subcategory {string}")
    public void userOpensSomeCategory(String subcategory) {
        new MainPage(driver).chooseSomeSubcategory(subcategory);
    }
}
