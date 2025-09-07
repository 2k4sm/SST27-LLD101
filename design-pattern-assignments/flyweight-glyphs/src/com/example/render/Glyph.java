package com.example.render;

import java.util.Objects;

public class Glyph {
    private final char ch;
    private final TextStyle style;

    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = Objects.requireNonNull(style, "style cannot be null");
    }

    public int drawCost() {
        return style.drawCost();
    }

    public char getCh() {
        return ch;
    }

    public String getFont() {
        return style.getFont();
    }

    public int getSize() {
        return style.getSize();
    }

    public boolean isBold() {
        return style.isBold();
    }
}
