package valueObjects;

public class User {

    private String email;
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.email = String.format("%s@gmail.com", login);
        this.password = password;
    }

    public User(String email, String login, String password) {
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
}
