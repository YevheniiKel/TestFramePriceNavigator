package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseSetup {
    DriverManager driverManager;

    public BaseSetup(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Before
    public void getNewDriver() {
        driverManager.setupController();
    }

    @After
    public void closeDriver() {

        driverManager.teardownController();
    }
}
