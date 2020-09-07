package util;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Const {

    public static final String VALID_EMAIL = "vasyaPupkin@gmail.com";
    public static final String VALID_USERNAME = "vasyaPupkin";
    public static final String VALID_PASSWORD = "qwerty";

    public static final String HOME_URL = "https://pn.com.ua/";

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
    public static final String PRODUCT_NOT_FOUND_NOTIFICATION = "Не найдено товаров";
    public static final String NOTHING_FOUND_NOTIFICATION = "Ничего не найдено по запросу";

    public static final String PRODUCT_URL = "https://pn.com.ua/md/3817488/";
    public static final String CATALOGUE_URL = "https://pn.com.ua/ct/1003/";
}

