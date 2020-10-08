package steps.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.driverUtils.DriverProvider;

import java.io.IOException;

public class BaseSetup {

    private DriverProvider driver;

    public BaseSetup(DriverProvider driverProvider) {
        this.driver = driverProvider;
    }

    @Before
    public void setupDriver() {
        driver.getDriver();
    }

    @After
    public void closeDriver(Scenario scenario) throws IOException {
      if (scenario.isFailed())
           driver.getDriver().saveScreenshot(scenario.getName());
        driver.getDriver().quiteDriver();
    }
}
