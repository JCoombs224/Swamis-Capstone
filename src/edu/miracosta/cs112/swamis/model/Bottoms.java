package edu.miracosta.cs112.swamis.model;

import java.text.NumberFormat;
import java.util.Objects;

public class Bottoms extends Clothing {
    int mType;
    String mSize;
    double mPrice;
    String typeString;

    /**
     * Gets the type of bottoms. Bottom types go as follows:
     * 0 = Trunk
     * 1 = Boardshorts
     * @return
     */
    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public String getSize() {
        return mSize;
    }

    public void setSize(String size) {
        mSize = size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bottoms bottoms = (Bottoms) o;
        return mType == bottoms.mType &&
                Double.compare(bottoms.mPrice, mPrice) == 0 &&
                Objects.equals(mSize, bottoms.mSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mType, mSize, mPrice);
    }

    public double calculateBottomsCost()
    {
        double price = 0;
        switch (mType)
        {
            case 0:
                price = 34.99;
                typeString = "Trunks";
                break;
            case 1:
                price = 29.99;
                typeString = "Board-Shorts";
                break;
                default:
                    System.err.println("Bottoms type error");
                    break;
        }
        return price;
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "Bottoms[" +
                "Type='" + typeString + '\'' +
                ", Size='" + mSize + '\'' +
                ", Price=" + currency.format(mPrice) +
                ", Sex=" + mSex +
                ']';
    }

    public Bottoms(int sex, int type, String size) {
        super(sex);
        mPrice = calculateBottomsCost();
        mType = type;
        mSize = size;
    }
}
