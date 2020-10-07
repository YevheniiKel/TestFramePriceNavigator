package dto;

import utils.dataUtils.CharDataForTestSite;
import utils.dataUtils.DataGenerator;

public class UserDto {

    private String email;
    private String login;
    private String password;

    public UserDto() {
    }

    public static UserDto createNewUser() {
        String username = DataGenerator.loginGenerator();
        return new UserDto()
                .setLogin(username)
                .setEmail(String.format("%s@gmail.com", username))
                .setPassword(DataGenerator.passGenerator());
    }

    public static UserDto createNotRegisteredUser() {
        return createNewUser();
    }

    public static UserDto createRegisteredUser() {
        return new UserDto()
                .setEmail(CharDataForTestSite.VALID_EMAIL)
                .setLogin(CharDataForTestSite.VALID_USERNAME)
                .setPassword(CharDataForTestSite.VALID_PASSWORD);
    }

    public static UserDto createInvalidEmailUser() {
        return new UserDto()
                .setEmail(DataGenerator.loginGenerator())
                .setPassword(DataGenerator.passGenerator());
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
