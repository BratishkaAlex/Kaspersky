package framework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static framework.utils.LoggerUtil.LOGGER;

public class PropertyManager {

    private static String pathToPropertiesFile = "src/main/resources/config.properties";
    private static String pathToEnDictionary = "src/main/resources/en.properties";
    private static String pathToRuDictionary = "src/main/resources/ru.properties";

    public static String getConfigProperty(String property) {
        LOGGER.warn("Reading property '" + property + "' from .properties file, can be FileNotFoundException or IOException");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(new File(pathToPropertiesFile)));
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException", e);
            System.out.println("Config.property wasn't found");
        } catch (IOException e) {
            LOGGER.error("IOException", e);
            System.out.println("Error in reading .property file");
        }
        return properties.getProperty(property);
    }

    public static String getWordFromDictionary(String word) {
        LOGGER.warn("Reading word '" + word + "' from .properties dictionary, can be FileNotFoundException or IOException");
        Properties properties = new Properties();
        try {
            switch (PropertyManager.getConfigProperty("language")) {
                case "ru":
                    properties.load(new FileReader(new File(pathToRuDictionary)));
                    break;
                case "en":
                    properties.load(new FileReader(new File(pathToEnDictionary)));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown language");
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException", e);
            System.out.println("Config.property wasn't found");
        } catch (IOException e) {
            LOGGER.error("IOException", e);
            System.out.println("Error in reading .property file");
        }
        return properties.getProperty(word);
    }

}
