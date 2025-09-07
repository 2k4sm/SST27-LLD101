package com.example.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TextStyleFactory {
    private final Map<String, TextStyle> styleCache = new HashMap<>();

 *
 *
    public TextStyle getStyle(String font, int size, boolean bold) {
        Objects.requireNonNull(font, "font cannot be null");

        String key = generateKey(font, size, bold);

        return styleCache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }


    private String generateKey(String font, int size, boolean bold) {
        return font + "|" + size + "|" + (bold ? "B" : "N");
    }
}
