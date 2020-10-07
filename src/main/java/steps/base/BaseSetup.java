package steps.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @After
    public void closeDriver() {
        driver.getDriver().quiteDriver();
    }
}
