package com.example.pen.components;

import com.example.pen.enums.Color;

public class Refill {
    private Color inkColor;
    private int inkLevel;

    public Refill(Color inkColor, int inkLevel) {
        this.inkColor = inkColor;
        this.inkLevel = inkLevel;
    }

    public Color getInkColor() {
        return inkColor;
    }

    public int getInkLevel() {
        return inkLevel;
    }

    public void consumeInk(int amount) {
        if (inkLevel >= amount) {
            inkLevel -= amount;
        } else {
            inkLevel = 0;
        }
    }
}
