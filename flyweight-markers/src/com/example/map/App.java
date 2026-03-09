package com.example.map;

import java.util.List;

public class App {
    public static void main(String[] args) {
        MarkerStyleFactory factory = new MarkerStyleFactory();
        MapDataSource mapDataSource = new MapDataSource(factory);

        System.out.println("Rendering markers...\n");
        List<MapMarker> markers = mapDataSource.loadMarkers();

        for (MapMarker m : markers) {
            m.render();
        }

        System.out.println("\nMarkers rendered: " + markers.size());
        QuickCheck.runCheck(factory);
    }
}
