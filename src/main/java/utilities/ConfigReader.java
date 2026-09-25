package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.Constants;

public final class ConfigReader {

    private static final Properties PROPERTIES =
            new Properties();

    static {

        try (FileInputStream input =
                     new FileInputStream(
                             Constants.CONFIG_FILE)) {

            PROPERTIES.load(input);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load "
                            + Constants.CONFIG_FILE,
                    e);
        }
    }

    private ConfigReader() {
    }

    public static String getProperty(String key) {

        return PROPERTIES.getProperty(key);
    }

    public static int getInt(
            String key,
            int defaultValue) {

        String value =
                PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        try {

            return Integer.parseInt(
                    value.trim());

        } catch (NumberFormatException e) {

            return defaultValue;
        }
    }

    public static boolean getBoolean(
            String key,
            boolean defaultValue) {

        String value =
                PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        return Boolean.parseBoolean(
                value.trim());
    }
}