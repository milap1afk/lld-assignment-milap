package com.example.pen.interfaces;

import com.example.pen.components.Refill;

public interface Refillable {
    void changeRefill(Refill newRefill);
    boolean isRefillable();
}
