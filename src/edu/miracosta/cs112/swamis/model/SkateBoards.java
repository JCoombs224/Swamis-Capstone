package edu.miracosta.cs112.swamis.model;


import java.io.Serializable;
import java.util.Objects;

public abstract class SkateBoards extends Item implements Serializable, Comparable {
    protected String mTrucks, mWheels;
    protected double mPrice;
    protected int mDeckSize;

    public SkateBoards(String trucks, String wheels, double price, int deckSize) {
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

    public void setDeckSize(int deckSize) {
        mDeckSize = deckSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkateBoards that = (SkateBoards) o;
        return Double.compare(that.mPrice, mPrice) == 0 &&
                Double.compare(that.mDeckSize, mDeckSize) == 0 &&
                mTrucks.equals(that.mTrucks) &&
                mWheels.equals(that.mWheels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mTrucks, mWheels, mPrice, mDeckSize);
    }
}
