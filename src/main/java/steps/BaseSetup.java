package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.driverUtils.DriverProvider;
import util.driverUtils.DriverWrapper;

public class BaseSetup {

    private DriverWrapper driver;

    public BaseSetup(DriverProvider driverProvider) {
        this.driver = driverProvider.getDriver();
    }

    @After
    public void closeDriver() {
        driver.quiteDriver();
    }
}
