package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.DriverProvider;

public class BaseSetup {
    DriverProvider driverProvider;

    public BaseSetup(DriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    @Before
    public void getNewDriver() {
        driverProvider.setupController();
    }

    @After
    public void closeDriver() {
        driverProvider.teardownController();
    }
}
