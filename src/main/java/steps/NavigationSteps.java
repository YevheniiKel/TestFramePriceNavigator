package steps;

import io.cucumber.java.en.Given;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.MainPage;
import util.DriverManager;
import util.elementUtils.WaitUtils;

public class NavigationSteps {
    protected DriverManager driverManager;
    protected MainPage mainPage;
    protected CataloguePage cataloguePage;
    protected ComparingPage comparingPage;
    private WaitUtils wait;


    public NavigationSteps(DriverManager driverManager) {

        wait = new WaitUtils(driverManager.getDriver());
        this.driverManager = driverManager;
    }

    @Given("User opens main page")
    public void userOnTheMainPage() {
        mainPage = new MainPage(driverManager.getDriver()).openPage();
    }

}
