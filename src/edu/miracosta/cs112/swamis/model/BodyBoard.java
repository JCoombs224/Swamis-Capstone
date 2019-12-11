package edu.miracosta.cs112.swamis.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public class BodyBoard extends OceanBoards implements Serializable {
    private String mCore;
    private String mTailShape;
    private String mColor;
    private static long SerialVersionUID = 12022019L;

    public BodyBoard(String name, String description, String brand, double price, double length, String core, String tailShape, String color) {
        super(name, description, brand, length, price);
        mCore = core;
        mTailShape = tailShape;
        mColor = color;
    }

    public String getCore() {
        return mCore;
    }

    public void setCore(String core) {
        mCore = core;
    }

    public String getTailShape() {
        return mTailShape;
    }

    public void setTailShape(String tailShape) {
        mTailShape = tailShape;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BodyBoard bodyBoard = (BodyBoard) o;
        return Double.compare(bodyBoard.mLength, mLength) == 0 &&
                Objects.equals(mCore, bodyBoard.mCore) &&
                Objects.equals(mTailShape, bodyBoard.mTailShape) &&
                Objects.equals(mColor, bodyBoard.mColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mLength, mCore, mTailShape, mColor);
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "BodyBoard [" +
                "Name = " + mName +
                ", Description = " + mDescription +
                ", Brand = " + mBrand +
                ", Length = " + mLength + " inches" +
                ",  " + mTailShape +
                ", " + mCore +
                ", Color = " + mColor +
                ", Price = " + currency.format(mPrice) +
                ']';
    }
}
