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
            "Компьютеры",
            "Электроника",
            "Бытовая техника",
            "Все для дома",
            "Мебель",
            "Стройка",
            "Дача, сад, огород"
    );


}

