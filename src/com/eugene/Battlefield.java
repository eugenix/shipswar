package com.eugene;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Battlefield {
    private Integer sizeX;

    private Integer sizeY;

    private ArrayList<ArrayList<Integer>> area;

    private HashMap<Ship, ArrayList<Point>> shipLocations;

    public Battlefield(Integer sizeX, Integer sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        shipLocations = new HashMap<Ship, ArrayList<Point>>();
        area = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < this.sizeX; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>(Collections.nCopies(this.sizeY, 0));
            area.add(row);
        }
    }

    public void allocateShip(Ship ship, ArrayList<Point> locations) {
        ships.add(ship);

//        for (Point p: ship.getCoordinates()) {
//            markPointOnArea(p.x, p.y);
//        }

    }


    public ArrayList<Ship> getShips() {
        return ships;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (ArrayList<Integer> row: area) {
            for (Integer field: row) {
                out.append(field);
                out.append(" ");
            }
            out.append("\n");
        }
        return out.toString();
    }

    private void markPointOnArea(Integer x, Integer y) {
        area.get(y).set(x, 1);
    }
}
