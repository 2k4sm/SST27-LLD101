package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;

    private static volatile boolean initialized = false;

    private final Properties props = new Properties();

    private AppSettings() {
        if (initialized) {
            throw new IllegalStateException("AppSettings instance already created");
        }
        initialized = true;
    }

    private static class Holder {
        private static final AppSettings INSTANCE = new AppSettings();
    }

    public static AppSettings getInstance() {
        return Holder.INSTANCE;
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

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
