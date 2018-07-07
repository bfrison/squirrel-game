package com.frison.blaise.assignment2;

import java.util.TreeMap;

/**
 * Created by Blaise on 30/oct./2017.
 */

public class Inventory extends TreeMap<Integer, Boolean> {
    public Inventory() {
        for (int i = 1; i <= 5; i++) {
            this.put(i, false);
        }
    }

    public boolean canPickup() {
        return this.containsValue(false);
    }

    public void pickup() {
        for (Entry<Integer, Boolean> entry : this.entrySet()) {
            if (!entry.getValue()) {
                this.put(entry.getKey(), true);
                return;
            }
        }
    }

    public void drop(int index) {
        if (index < 1 || index > 5) {
            throw new IllegalArgumentException();
        }
        this.put(index, false);
    }
}
