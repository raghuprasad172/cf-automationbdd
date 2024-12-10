package com.cfspl.nbfc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {

    public static Properties properties;

    /**
     * / This method is used to retrieve the values from config.properties file
     * @param configFilePath
     * @param key
     * @return
     */
    public static String getPropertyValue(String configFilePath, String key) {
        String keyValue = "";
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(configFilePath);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        keyValue = properties.getProperty(key);
        return keyValue;
    }

}
