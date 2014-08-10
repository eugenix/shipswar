package com.eugene;

public abstract class Ship {
    protected String name;

    protected ShipState state;

    protected Integer countOfDecks;

    public Ship() {
        state = ShipState.STATUS_ALIVE;
    }

    public ShipState getState() {
        return state;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    public Object getCountOfDecks() {
        return countOfDecks;
    }
}
