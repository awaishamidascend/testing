package test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Meeting_Join {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("linkcre.properties")) {
            if (input == null) {
                throw new IOException("login.properties file not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
