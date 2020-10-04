package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.MainPage;
import util.DriverProvider;
import util.elementUtils.WaitUtils;

public class NavigationSteps {
    protected DriverProvider driverProvider;
    protected MainPage mainPage;
    protected CataloguePage cataloguePage;
    protected ComparingPage comparingPage;
    private WaitUtils wait;


    public NavigationSteps(DriverProvider driverProvider) {

        wait = new WaitUtils(driverProvider.getDriver());
        this.driverProvider = driverProvider;
    }

    @Given("User opens main page")
    public void userOnTheMainPage() {
        mainPage = new MainPage(driverProvider.getDriver()).openPage();
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
