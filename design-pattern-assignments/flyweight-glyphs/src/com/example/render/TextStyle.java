package com.example.render;

import java.util.Objects;

public final class TextStyle {
    public final String font;
    public final int size;
    public final boolean bold;

    public TextStyle(String font, int size, boolean bold) {
        this.font = Objects.requireNonNull(font, "font");
        this.size = size;
        this.bold = bold;
    }
}


