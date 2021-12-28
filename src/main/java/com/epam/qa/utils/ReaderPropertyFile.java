package com.epam.qa.utils;

import com.epam.qa.constants.FrameworkConstants;
import com.epam.qa.enums.ConfigProperties;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ReaderPropertyFile {

    private static Properties prop = new Properties();
    private static final Map<String, String> PROPMAP = new HashMap<>();

    private ReaderPropertyFile() {

    }

    static {

        try {
            FileInputStream fiS = new FileInputStream(FrameworkConstants.getConfigPath());
            prop.load(fiS);

            for (Map.Entry<Object, Object> key : prop.entrySet()) {
                PROPMAP.put(String.valueOf(key.getKey()), String.valueOf(key.getValue()).trim());

            }
        } catch (Exception e) {
            System.out.println("Error loading config.properties " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static String getValue(ConfigProperties key) throws Exception {
        String value;
        if (Objects.isNull(key) || Objects.isNull(PROPMAP.get(key))) {
            value = PROPMAP.get(key.name().toLowerCase());
        } else {
            throw new Exception("Property name:  " + key + " is not found. Please check config.properties");
        }

        return value;
    }
}
