package com.ocr.gan.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final Properties properties = new Properties();

    public static void readProperties() {

        try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")){

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            properties.load(input);

        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int getNbrValues() { return Integer.valueOf(properties.getProperty("NBR_VALUES"));}
    public static int getNbrRoundMax() { return Integer.valueOf(properties.getProperty("NBR_ROUND_MAX"));}
    public static int getNbrChoice() { return Integer.valueOf(properties.getProperty("NBR_CHOICE"));}
    public static boolean MODE_DEV() {return Boolean.valueOf(properties.getProperty("MODE_DEV"));}
}
