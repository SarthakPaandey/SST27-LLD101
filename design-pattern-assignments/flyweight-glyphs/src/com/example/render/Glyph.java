package com.example.render;

public class Glyph {
    // extrinsic state: the character
    private final char ch;
    // intrinsic state: shared style
    private final TextStyle style;

    public Glyph(char ch, TextStyle style) {
        this.ch = ch; this.style = style;
    }

    public int drawCost() { return style.size + (style.bold ? 10 : 0); }
    public char getCh() { return ch; }
    public TextStyle getStyle() { return style; }
}
