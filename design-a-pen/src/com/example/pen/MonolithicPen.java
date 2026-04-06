package com.example.pen;

import com.example.pen.enums.PenType;
import com.example.pen.enums.Color;

// A monolithic class violating Single Responsibility and Open/Closed principles
public class MonolithicPen {
    private PenType type;
    private Color inkColor;
    private int inkLevel;
    private String brand;

    public MonolithicPen(PenType type, Color inkColor, String brand) {
        this.type = type;
        this.inkColor = inkColor;
        this.brand = brand;
        this.inkLevel = 100; // default full
    }

    public void write(String text) {
        if (inkLevel <= 0) {
            System.out.println("Cannot write. Out of ink!");
            return;
        }

        // Tightly coupled, non-extensible writing logic
        if (type == PenType.BALL) {
            System.out.println("Writing smoothly with Ball pen [" + brand + "]: " + text);
            inkLevel -= 5;
        } else if (type == PenType.GEL) {
            System.out.println("Writing vividly with Gel pen [" + brand + "]: " + text);
            inkLevel -= 10;
        } else if (type == PenType.FOUNTAIN) {
            System.out.println("Writing gracefully with Fountain pen [" + brand + "]: " + text);
            inkLevel -= 15;
        } else if (type == PenType.MARKER) {
            System.out.println("Writing boldly with Marker [" + brand + "]: " + text);
            inkLevel -= 20;
        } else {
            System.out.println("Unknown pen type.");
        }
    }

    public boolean isRefillable() {
        // Tightly coupled boolean logic
        return type == PenType.BALL || type == PenType.GEL || type == PenType.FOUNTAIN;
    }

    public void changeRefill(Color newColor) {
        if (isRefillable()) {
            this.inkColor = newColor;
            this.inkLevel = 100;
            System.out.println("Refilled the " + type + " pen with " + newColor + " ink.");
        } else {
            System.out.println("This pen is a " + type + " and cannot be refilled.");
        }
    }
}
