package util.dataUtils;

import static util.PropertyReader.getProperty;

public class CharDataForTestSite {
    public static final String HOME_URL = getProperty("HOME_URL");

    public static final String VALID_EMAIL = getProperty("VALID_EMAIL");
    public static final String VALID_USERNAME = getProperty("VALID_USERNAME");
    public static final String VALID_PASSWORD = getProperty("VALID_PASSWORD");

    public static final String BASE_SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm1234567890";
    public static final String EMAIL_SYMBOLS = BASE_SYMBOLS + "-_";
}

