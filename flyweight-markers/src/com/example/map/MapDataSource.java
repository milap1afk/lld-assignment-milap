package com.example.map;

import java.util.ArrayList;
import java.util.List;

public class MapDataSource {
    private final MarkerStyleFactory factory;

    public MapDataSource(MarkerStyleFactory factory) {
        this.factory = factory;
    }

    public List<MapMarker> loadMarkers() {
        List<MapMarker> markers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            markers.add(new MapMarker(28.6 + (i * 0.01), 77.2 + (i * 0.01), "A" + i,
                    factory.getStyle("PIN", "RED", 12, true)));
        }

        for (int i = 0; i < 10; i++) {
            markers.add(new MapMarker(29.1 + (i * 0.01), 78.1 + (i * 0.01), "B" + i,
                    factory.getStyle("SQUARE", "BLUE", 10, false)));
        }

        for (int i = 0; i < 10; i++) {
            markers.add(new MapMarker(30.1 + (i * 0.01), 79.1 + (i * 0.01), "C" + i,
                    factory.getStyle("CIRCLE", "GREEN", 8, true)));
        }

        return markers;
    }
}
