package stepDefinitions;

import dto.UserDto;
import pages.HeaderAnyPage;

public class LoginFeatureSteps {

    private HeaderAnyPage headerAnyPage;
    private DriverManager driverManager;

    private UserDto registeredUser;

    public LoginFeatureSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
        registeredUser = UserDto.createRegisteredUser();
    }


}
