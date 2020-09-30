package steps;

import io.cucumber.java.en.Given;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.MainPage;

public class NavigationSteps {
    protected DriverManager driverManager;
    protected MainPage mainPage;
    protected CataloguePage cataloguePage;
    protected ComparingPage comparingPage;

    public NavigationSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Given("User opens main page")
    public void userOnTheMainPage() {
        mainPage = new MainPage(driverManager.getDriver()).openPage();
    }

}
