package edu.miracosta.cs112.swamis.model;

import java.io.Serializable;
import java.util.Objects;

public class Trick extends SkateBoards implements Serializable, Comparable {
    private String mBrand;
    private int mWheelSize;

    /** Constructor of the Trick class.
     * Using inheritance by pulling fields from the abstract parent, SKateBoards.
     * @param trucks
     * @param wheels
     * @param price
     * @param deckSize
     * @param brand
     * @param wheelSize
     */
    public Trick(String trucks, String wheels, double price, double deckSize, String brand, int wheelSize) {
        super(trucks, wheels, price, deckSize);
        mBrand = brand;
        mWheelSize = wheelSize;
    }


    /** Getters and setters for the fields
     * of the Trick class */
    public String getBrand() {
        return mBrand;
    }

    public void setBrand(String brand) {
        mBrand = brand;
    }

    public int getWheelSize() {
        return mWheelSize;
    }

    public void setWheelSize(int wheelSize) {
        mWheelSize = wheelSize;
    }

    @Override
    public String toString() {
        return "Trick Board";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trick trick = (Trick) o;
        return mWheelSize == trick.mWheelSize &&
                mBrand.equals(trick.mBrand);
    }

    /** Implementing the Comparable interface */
    public int compareTo(Object o) {
        return -1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mBrand, mWheelSize);
    }
}
