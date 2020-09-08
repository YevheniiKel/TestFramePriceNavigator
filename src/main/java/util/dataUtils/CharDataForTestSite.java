package util.dataUtils;

import java.util.List;

import static java.util.Arrays.asList;
import static util.PropertyReader.getProperty;

public class CharDataForTestSite {
    public static final String HOME_URL = getProperty("HOME_URL");
    public static final String PRODUCT_URL = getProperty("PRODUCT_URL");
    public static final String CATALOGUE_URL = getProperty("CATALOGUE_URL");

    public static final String VALID_EMAIL = getProperty("VALID_EMAIL");

    public static final String VALID_USERNAME = getProperty("VALID_USERNAME");

    public static final String VALID_PASSWORD = getProperty("VALID_PASSWORD");

    public static final String BASE_SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm1234567890";
    public static final String EMAIL_SYMBOLS = BASE_SYMBOLS + "-_";

    public static final List<String> CATEGORIES = asList(
            "Ноутбуки",
            "Планшеты",
            "Игровые приставки",
            "Беспроводное оборудование",
            "Видеокарты",
            "Жесткие диски",
            "Процессоры",
            "Материнские платы",
            "Память",
            "Мыши",
            "Мониторы",
            "Принтеры и МФУ",
            "Клавиатуры",
            "USB флешки"
    );

    public static final String INVALID_SEARCH_QUERY = "fjbhjgjsdkjfglsdf";
}

