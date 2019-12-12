package edu.miracosta.cs112.swamis.model;

import java.text.NumberFormat;
import java.util.HashMap;

public class Top extends Clothing {
    int mType;
    String mSize;
    String mColor;
    double mPrice;
    String typeString;

    /**
     * Gets the type of top the object is. Tops types go as follows:
     * 0 = TShirt
     * 1 = Long Sleeve
     * 2 = Tank Top
     * 3 = Hoodie
     *
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

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public double calculateTopCost()
    {
        double price = 0.0;
        switch (mType)
        {
            case 0:
                price = 24.99;
                typeString = "T-Shirt";
                break;
            case 1:
                price = 29.99;
                typeString = "Long-Sleeve T-Shirt";
                break;
            case 2:
                price = 19.99;
                typeString = "Tank Top";
                break;
            case 3:
                price = 64.99;
                typeString = "Hoodie";
                break;
        }
        return price;
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "Top[" +
                "Type=" + typeString +
                ", Size='" + mSize + '\'' +
                ", Color='" + mColor + '\'' +
                ", Price=" + currency.format(mPrice) +
                ", Sex=" + mSex +
                ']';
    }

    public Top(String sex, int type, String size, String color) {
        super(sex);
        mPrice = calculateTopCost();
        mType = type;
        mSize = size;
        mColor = color;
    }
}
