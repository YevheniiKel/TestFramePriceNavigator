package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseSetup {
    Controller controller;

    public BaseSetup(Controller controller) {
        this.controller = controller;
    }

    @Before
    public void getNewDriver() {
        controller.setupController();
    }

    @After
    public void closeDriver() {
        controller.teardownController();
    }
}
