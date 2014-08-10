package com.eugene;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private static final int MAX_AREA_SIZE = 5;

    private Battlefield battlefield;

    private ArrayList<Ship> shipSet;

    public static void main(String[] args) {
        try {
            new Game().start();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void start() {
        init();

        while (!isGameFinished()) {
            Point p = getUserInput();
            TurnResult result = checkUserTurn(p);
            printResult(result);
        }
    }

    private Boolean isGameFinished() {
        Boolean res = true;

        for (Ship s: battlefield.getShips()) {
            if (s.getState() == ShipState.STATUS_ALIVE) {
                res = false;
            }
        }
        return res;
    }

    private void printResult(TurnResult result) {

    }

    private TurnResult checkUserTurn(Point p) {
        return null;
    }

    private Point getUserInput() {
        return null;
    }

    private void init() {
        battlefield  = new Battlefield(MAX_AREA_SIZE, MAX_AREA_SIZE);

        shipSet = new ArrayList<Ship>(){{
            add(new SingleDeckShip());
            add(new SingleDeckShip());
            add(new DoubleDeckShip());
        }};

        //battlefield.setAllocationStrategy(new AllocationRandomStrategy());
        for (Ship ship: shipSet) {
            battlefield.allocateShipRandomly(ship);
        }
    }
}
