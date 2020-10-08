package steps.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.driverUtils.DriverProvider;

public class BaseSetup {

    private DriverProvider driver;

    public BaseSetup(DriverProvider driverProvider) {
        this.driver = driverProvider;
    }

    @Before
    public void setupDriver() {
        driver.getDriver();
    }

    @After(order = 1)
    public void ifTestFalisTakeScreenshot(Scenario scenario) {
        if (scenario.isFailed())
            driver.getDriver().saveScreenshot(scenario.getName());
    }

    @After(order = 0)
    public void closeDriver() {
        driver.getDriver().quiteDriver();
    }
}
