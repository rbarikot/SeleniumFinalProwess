package com.API.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.API.constants.frameworkConstant.CONFIG_FILE_PATH;

public class ConfigManager {
    private static final Properties PROPERTIES = new Properties();
    private static ConfigManager instance;

    private ConfigManager() {
        loadProperties();
    }

    /**
     * Singleton instance getter
     */
    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    /**
     * Load properties from the configuration file
     */
    private void loadProperties() {
        try (InputStream inputStream = new FileInputStream(CONFIG_FILE_PATH)) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    /**
     * Get a property value by key
     */
    public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    /**
     * Get a property value with a default fallback
     */
    public String getProperty(String key, String defaultValue) {
        return PROPERTIES.getProperty(key, defaultValue);
    }

    /**
     * Get integer property
     */
    public int getIntProperty(String key) {
        String value = getProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Failed to parse integer property: " + key, e);
        }
    }

    /**
     * Get boolean property
     */
    public boolean getBooleanProperty(String key) {
        String value = getProperty(key);
        return Boolean.parseBoolean(value);
    }
}
