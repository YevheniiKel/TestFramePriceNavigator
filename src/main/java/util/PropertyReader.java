package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private PropertyReader() {
    }


    private static String getPropertyFromFile(String name, String pathToPropertyFile) {
        try {
            Properties props = new Properties();
            props.load(PropertyReader.class.getResourceAsStream(pathToPropertyFile));
            String property = props.getProperty(name);
            if (property == null) {
                throw new IllegalArgumentException(String.format("Could not read property with key: %s", name));
            }
            System.out.println(property);
            return property;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getProperty(String name) {
        return getPropertyFromFile(name, "/config.properties");


    }

    public static String getMessage(String forAssert) {
        return getPropertyFromFile(forAssert, "/assertMessages.properties");
    }
}
