package com.example.pen;

import com.example.pen.enums.PenType;
import com.example.pen.enums.Color;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Design A Pen Simulator ===");

        MonolithicPen myBallPen = new MonolithicPen(PenType.BALL, Color.BLUE, "Reynolds");
        myBallPen.write("Hello World!");
        myBallPen.write("Writing code is fun.");

        MonolithicPen myMarker = new MonolithicPen(PenType.MARKER, Color.BLACK, "Sharpie");
        myMarker.write("Big bold text.");
        
        System.out.println("\nTrying to refill marker...");
        myMarker.changeRefill(Color.BLACK);

        System.out.println("\nTrying to refill ball pen...");
        myBallPen.changeRefill(Color.RED);
        myBallPen.write("Now it writes in red.");

        System.out.println("\n=== Simulator Finished ===");
    }
}
