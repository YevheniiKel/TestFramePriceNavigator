package stepDefinitions;

import dto.UserDto;
import pages.HeaderAnyPage;

public class LoginFeatureSteps {

    private HeaderAnyPage headerAnyPage;
    private Controller controller;

    private UserDto registeredUser;

    public LoginFeatureSteps(Controller controller) {
        this.controller = controller;
        registeredUser = UserDto.createRegisteredUser();
    }


}
