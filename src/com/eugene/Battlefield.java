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
        shipLocations.put(ship, locations);
    }

    public void allocateShipRandomly(Ship ship) {
        ArrayList<Point> points = new ArrayList<Point>();

        Integer tryNum = 0;
        Integer triesLimit = 50;

        while (tryNum < triesLimit) {

            // генерируем первую точку
            Integer startX = (int) (sizeX * Math.random());
            Integer startY = (int) (sizeY * Math.random());

            Boolean res = isAvaliablePoint(new Point(startX, startY));
            tryNum++;

            if (!res) {
                continue;
            }
            points.add(new Point(startX, startY));

            Boolean found = false;
            // генерируем вторую точку
            if (ship.getCountOfDecks() > 1) {
                Integer[][] deltas = new Integer[][] { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };

                for (int i = 0; i < deltas.length; i++) {
                    Integer nextX = startX + deltas[i][0];
                    Integer nextY = startY + deltas[i][1];

                    res = isAvaliablePoint(new Point(nextX, nextY));

                    // нашли точку
                    if (res) {
                        startX = nextX;
                        startY = nextY;
                        points.add(new Point(startX, startY));
                        found = true;
                        break;
                    }
                }
            } else {
                break;
            }

            if (!found) {
                continue;
            }

            // генерируем остальные точки
            Integer[][] deltas = new Integer[][] { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };

            // получаем разницу первых двух точек





        }






    }

    private Boolean isAvaliablePoint(Point point) {
        return null;
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
