package edu.miracosta.cs112.swamis.model;

import java.io.Serializable;

public abstract class SkateBoards extends Item implements Serializable {
    protected String mTrucks, mWheels;
    protected double mPrice, mDeckSize;

    public SkateBoards(String trucks, String wheels, double price, double deckSize) {
        mTrucks = trucks;
        mWheels = wheels;
        mPrice = price;
        mDeckSize = deckSize;
    }

    /** Getters and setters for fields of SkateBoards class */
    public String getTrucks() {
        return mTrucks;
    }

    public void setTrucks(String trucks) {
        mTrucks = trucks;
    }

    public String getWheels() {
        return mWheels;
    }

    public void setWheels(String wheels) {
        mWheels = wheels;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getDeckSize() {
        return mDeckSize;
    }

    public void setDeckSize(double deckSize) {
        mDeckSize = deckSize;
    }
}
