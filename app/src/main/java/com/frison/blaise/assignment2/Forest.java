package com.frison.blaise.assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Blaise on 29/oct./2017.
 */

public class Forest {

    private final static int MAP_SIZE = 100;
    private final static int MIN_X = 1;
    private final static int MAX_X = 10;
    private final static int MIN_Y = 1;
    private final static int MAX_Y = 10;
    private final static int T = R.drawable.tree_icon;
    private final static int G = R.drawable.grass_icon;
    private final static int S = R.drawable.squirrel_sprite;
    private final static int A = R.drawable.acorn_icon;
    private int x;
    private int y;
    private Set<Acorn> acorns;

    public enum Direction {UP, LEFT, RIGHT, DOWN}

    public Forest(int x, int y) {
        if (getIndex(x, y) == T) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
        acorns = initateAcorns();
    }

    public static List<Integer> getOriginalList() {
        List<Integer> forest = new ArrayList<>(MAP_SIZE);
        forest.addAll(Arrays.asList(T, T, T, G, G, G, T, G, G, T));
        forest.addAll(Arrays.asList(T, G, G, G, T, G, G, G, T, T));
        forest.addAll(Arrays.asList(T, G, G, G, T, G, G, G, T, G));
        forest.addAll(Arrays.asList(T, T, G, G, T, T, G, T, T, G));
        forest.addAll(Arrays.asList(G, G, G, G, G, T, T, G, G, G));
        forest.addAll(Arrays.asList(T, T, T, G, G, G, G, G, T, T));
        forest.addAll(Arrays.asList(T, T, T, G, T, G, G, T, G, G));
        forest.addAll(Arrays.asList(T, T, G, G, G, G, G, T, G, T));
        forest.addAll(Arrays.asList(G, G, G, G, T, T, G, G, G, G));
        forest.addAll(Arrays.asList(T, T, G, G, G, T, T, G, G, T));
        return forest;
    }

    public List<Integer> getThisList() {
        List<Integer> forest = getOriginalList();
        for (Acorn acorn : acorns) {
            int acornIndex = getIndex(acorn.getX(), acorn.getY());
            if (getOriginalList().get(acornIndex) == T) {
                throw new IllegalArgumentException();
            } else {
                forest.set(acornIndex, A);
            }
        }
        int squirrelIndex = getIndex(this.getX(), this.getY());
        forest.set(squirrelIndex, S);
        return forest;
    }

    public void move(Direction direction) {
        if (isMovementPossible(direction)) {
            switch (direction) {
                case UP:
                    this.y--;
                    break;
                case LEFT:
                    this.x--;
                    break;
                case RIGHT:
                    this.x++;
                    break;
                case DOWN:
                    this.y++;
                    break;
            }
        }
    }

    public boolean squirrelOnAcorn() {
        return this.acorns.contains(new Acorn(x, y));
    }

    public void removeAcorn() {
        this.acorns.remove(new Acorn(x, y));
    }

    public void addAcorn() {
        this.acorns.add(new Acorn(x, y));
    }

    public static int getIndex(int x, int y) {
        return 10 * (y - 1) + x - 1;
    }

    public boolean isMovementPossible(Direction direction) {
        switch (direction) {
            case UP:
                if (y == MIN_Y) {
                    return false;
                } else if (getOriginalList().get(getIndex(x, y) - 10) == T) {
                    return false;
                } else {
                    return true;
                }
            case LEFT:
                if (x == MIN_X) {
                    return false;
                } else if (getOriginalList().get(getIndex(x, y) - 1) == T) {
                    return false;
                } else {
                    return true;
                }
            case RIGHT:
                if (x == MAX_X) {
                    return false;
                } else if (getOriginalList().get(getIndex(x, y) + 1) == T) {
                    return false;
                } else {
                    return true;
                }
            case DOWN:
                if (y == MAX_Y) {
                    return false;
                } else if (getOriginalList().get(getIndex(x, y) + 10) == T) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    private Set<Acorn> initateAcorns() {
        Set<Acorn> acorns = new HashSet<>(12);
        acorns.add(new Acorn(8, 1));
        acorns.add(new Acorn(3, 2));
        acorns.add(new Acorn(1, 5));
        acorns.add(new Acorn(5, 5));
        acorns.add(new Acorn(9, 7));
        acorns.add(new Acorn(3, 8));
        return acorns;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
