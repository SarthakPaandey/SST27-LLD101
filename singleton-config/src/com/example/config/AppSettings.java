package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    private static volatile AppSettings instance;
    private final Properties props = new Properties();
    
    private AppSettings() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance");
        }
    }

    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (AppSettings.class) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
    
    protected Object readResolve() {
        return getInstance();
    }
}
