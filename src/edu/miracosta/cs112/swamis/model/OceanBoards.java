package edu.miracosta.cs112.swamis.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public abstract class OceanBoards extends Item implements Serializable {

    protected String mName;
    protected String mDescription;
    protected String mBrand;
    protected double mPrice;
    protected double mLength;
    private static long SerialVersionUID = 12022019L;
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    protected OceanBoards(String name, String description, String brand, double length, double price) {
        mName = name;
        mDescription = description;
        mBrand = brand;
        mLength = length;
        mPrice = price;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getBrand() {
        return mBrand;
    }

    public void setBrand(String brand) {
        mBrand = brand;
    }
    public double getLength() {
        return mLength;
    }

    public void setLength(double length) {
        mLength = length;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OceanBoards that = (OceanBoards) o;
        return Double.compare(that.mPrice, mPrice) == 0 &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mDescription, that.mDescription) &&
                Objects.equals(mBrand, that.mBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mDescription, mBrand, mPrice);
    }

}
