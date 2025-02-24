package test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ParticipantEmailReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream is = ParticipantEmailReader.class.getClassLoader().getResourceAsStream("par_email.properties")) {
            if (is == null) {
                throw new IOException("participantEmails.properties not found in classpath");
            }
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getEmails() {
        List<String> emails = new ArrayList<>();
        for (Object key : properties.keySet()) {
            emails.add(properties.getProperty((String) key));
        }
        return emails;
    }
}
