package com.example.render;

public class App {
    public static void main(String[] args) {
        Renderer r = new Renderer();

        // Create a string with many repetitions to demonstrate flyweight pattern
        String text = "Hello Flyweight! ".repeat(2000);
        System.out.println("Text length: " + text.length() + " characters");

        // Check style reuse via reference equality
        TextStyleFactory factory = new TextStyleFactory();
        TextStyle style1 = factory.getStyle("Inter", 14, true);
        TextStyle style2 = factory.getStyle("Inter", 14, true);
        TextStyle style3 = factory.getStyle("Inter", 14, false);

        System.out.println("Style reuse check (same config):");
        System.out.println("style1 == style2: " + (style1 == style2)); // Should be true
        System.out.println("style1 == style3: " + (style1 == style3)); // Should be false

        // Render the text and measure cost
        System.out.println("Cost=" + r.render(text));
    }
}
