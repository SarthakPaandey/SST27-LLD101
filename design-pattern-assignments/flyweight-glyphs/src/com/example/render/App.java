package com.example.render;
public class App {
    public static void main(String[] args) {
        // measure cost of rendering a large text using shared styles
        Renderer r = new Renderer();
        System.out.println("Cost=" + r.render("Hello Flyweight! ".repeat(2000)));
    }
}
