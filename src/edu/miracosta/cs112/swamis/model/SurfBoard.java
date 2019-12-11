package edu.miracosta.cs112.swamis.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public class SurfBoard extends OceanBoards implements Serializable {
    private double mWidth;
    private double mThickness;
    private double mVolume;
    private boolean mEpoxy;
    private static long SerialVersionUID = 12022019L;
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    public SurfBoard(String name, String description, String brand, double length, double price, double width, double thickness, double volume, boolean epoxy) {
        super(name, description, brand, length, price);
        mWidth = width;
        mThickness = thickness;
        mVolume = volume;
        mEpoxy = epoxy;
    }

    public double getWidth() {
        return mWidth;
    }

    public void setWidth(double width) {
        mWidth = width;
    }

    public double getThickness() {
        return mThickness;
    }

    public void setThickness(double thickness) {
        mThickness = thickness;
    }

    public double getVolume() {
        return mVolume;
    }

    public void setVolume(double volume) {
        mVolume = volume;
    }

    public boolean isEpoxy() {
        return mEpoxy;
    }

    public void setEpoxy(boolean epoxy) {
        mEpoxy = epoxy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SurfBoard surfBoard = (SurfBoard) o;
        return Double.compare(surfBoard.mLength, mLength) == 0 &&
                Double.compare(surfBoard.mWidth, mWidth) == 0 &&
                Double.compare(surfBoard.mThickness, mThickness) == 0 &&
                Double.compare(surfBoard.mVolume, mVolume) == 0 &&
                mEpoxy == surfBoard.mEpoxy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mLength, mWidth, mThickness, mVolume, mEpoxy);
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "SurfBoard [" +
                "Name = " + mName +
                ", Description = " + mDescription +
                ", Brand = " + mBrand +
                ", Length = " + mLength + " inches" +
                ", Width = " + mWidth + " inches" +
                ", Thickness = " + mThickness + " inches" +
                ", Volume = " + mVolume + " Liters" +
                ", Epoxy = " + mEpoxy +
                ", Price = " + currency.format(mPrice) + // TODO format price
                ']';
    }
}
