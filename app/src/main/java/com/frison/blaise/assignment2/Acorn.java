package com.frison.blaise.assignment2;

/**
 * Created by Blaise on 29/oct./2017.
 */

public class Acorn {
    private final int x;
    private final int y;
    public static final int DRAWABLE_ID = R.drawable.acorn_icon;

    public Acorn(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Acorn) {
            return this.getX() == ((Acorn) o).getX() && this.getY() == ((Acorn) o).getY();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        return new Integer(x).hashCode() + new Integer(y).hashCode();
    }
}
