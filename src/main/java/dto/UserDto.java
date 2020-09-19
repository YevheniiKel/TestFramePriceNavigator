package dto;

import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;

public class UserDto {

    private String email;
    private String login;
    private String password;

    public UserDto() {
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public static UserDto createRegisteredUser() {
        return new UserDto()
                .setEmail(CharDataForTestSite.VALID_EMAIL)
                .setLogin(CharDataForTestSite.VALID_USERNAME)
                .setPassword(CharDataForTestSite.VALID_PASSWORD);
    }

    public static UserDto createNotRegisteredUser() {
        return new UserDto()
                .setEmail(String.format("%s@gmail.com", DataGenerator.loginGenerator()))
                .setPassword(DataGenerator.passGenerator());
    }

    public static UserDto createInvalidEmailUser() {
        return new UserDto()
                .setEmail(DataGenerator.loginGenerator())
                .setPassword(DataGenerator.passGenerator());
    }

    public static UserDto createNewUser() {
        String username = DataGenerator.loginGenerator();
        return new UserDto()
                .setLogin(username)
                .setEmail(String.format("%s@gmail.com", username))
                .setPassword(DataGenerator.passGenerator());
    }
}
