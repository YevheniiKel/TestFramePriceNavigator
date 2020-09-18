package dto;

import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;

public class UserDTO {

    private String email;
    private String login;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String email, String login, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
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

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTO setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public static UserDTO createRegisteredUser() {
        return new UserDTO()
                .setEmail(CharDataForTestSite.VALID_EMAIL)
                .setLogin(CharDataForTestSite.VALID_USERNAME)
                .setPassword(CharDataForTestSite.VALID_PASSWORD);
    }

    public static UserDTO createNotRegisteredUser() {
        return new UserDTO()
                .setEmail(String.format("%s@gmail.com", DataGenerator.loginGenerator()))
                .setPassword(DataGenerator.passGenerator());
    }

    public static UserDTO CreateInvalidEmailUser() {
        return new UserDTO()
                .setEmail(DataGenerator.loginGenerator())
                .setPassword(DataGenerator.passGenerator());
    }

    public static UserDTO createNewUser() {
        String username = DataGenerator.loginGenerator();
        return new UserDTO()
                .setLogin(username)
                .setEmail(String.format("%s@gmail.com", username))
                .setPassword(DataGenerator.passGenerator());
    }
}
