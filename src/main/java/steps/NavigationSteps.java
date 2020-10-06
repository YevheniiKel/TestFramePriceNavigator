package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.CataloguePage;
import pages.MainPage;
import util.driverUtils.DriverWrapper;

public class NavigationSteps {
    private DriverWrapper driver;
    protected MainPage mainPage;
    protected CataloguePage cataloguePage;


    public NavigationSteps(DriverWrapper driver) {
        this.driver = driver;
    }

    @Given("User opens main page")
    public void userOnTheMainPage() {
        mainPage = new MainPage(driver).openPage();
    }

    @And("User opens some subcategory")
    public void userOpensSomeCategory() {
        cataloguePage = mainPage.chooseAnySubCategory();
    }

    @And("User opens subcategory {string}")
    public void userOpensSomeCategory(String subcategory) {
        cataloguePage = mainPage.chooseSomeSubcategory(subcategory);
    }
}
