package edu.miracosta.cs112.swamis.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public class Cruiser extends SkateBoards implements Serializable, Comparable {
    private String mMaterial;
    private int mTruckSize;

    /** Constructor of the Cruiser class
     * Using inheritance by pulling fields from the abstract parent class, Skateboards.
     * @param trucks
     * @param wheels
     * @param price
     * @param deckSize
     * @param material
     * @param truckSize
     */
    public Cruiser(String trucks, String wheels, double price, int deckSize, String material, int truckSize) {
        super(trucks, wheels, price, deckSize);
        mMaterial = material;
        mTruckSize = truckSize;
    }


    /** Getters and setter for the feilds of
     * the Cruiser class.*/
    public String getMaterial() {
        return mMaterial;
    }

    public void setMaterial(String material) {
        mMaterial = material;
    }

    public int getTruckSize() {
        return mTruckSize;
    }

    public void setTruckSize(int truckSize) {
        mTruckSize = truckSize;
    }

    @Override
    public String toString() {
        NumberFormat dollarSign = NumberFormat.getCurrencyInstance();
        return "Cruiser[Trucks: " + mTrucks + ", Wheels: " + mWheels + ", Price"
                + dollarSign.format(mPrice) + ", Deck Size: " + mDeckSize
                + ", Material: " + mMaterial + ", Truck Size :" + mTruckSize + "]";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cruiser cruiser = (Cruiser) o;
        return mTruckSize == cruiser.mTruckSize &&
                mMaterial.equals(cruiser.mMaterial);
    }

    /** Implementing the interface Comparable */
     public int compareTo(Object o) {
         return -1;
     }

    @Override
    public int hashCode() {
        return Objects.hash(mMaterial, mTruckSize);
    }
}
