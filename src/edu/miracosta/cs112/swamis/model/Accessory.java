package edu.miracosta.cs112.swamis.model;

import java.text.NumberFormat;
import java.util.Objects;

public class Accessory extends Clothing {
    int mType;
    double mPrice;
    String typeString;

    /**
     * Gets the type of Accessory. Accessory types go as follows:
     * 0 = Hat
     * 1 = Helmet
     * 2 = Sunglasses
     * 3 = Wallet
     * 4 = Belt
     * @return
     */
    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Accessory accessory = (Accessory) o;
        return mType == accessory.mType &&
                Double.compare(accessory.mPrice, mPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mType, mPrice);
    }

    public double calculateAccessoryCost()
    {
        double price = 0;
        switch (mType)
        {
            case 0:
                price = 14.99;
                typeString = "Hat";
                break;
            case 1:
                price = 39.99;
                typeString = "Helmet";
                break;
            case 2:
                price = 14.99;
                typeString = "Sunglasses";
                break;
            case 3:
                price = 19.99;
                typeString = "Wallet";
                break;
            case 4:
                price = 24.99;
                typeString = "Belt";
                break;
        }
        return price;
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "Accessory[" +
                "Type='" + typeString + '\'' +
                ", Price=" + currency.format(mPrice) +
                ", Sex=" + mSex +
                ']';
    }

    public Accessory(int sex, int type) {
        super(sex);
        mPrice = calculateAccessoryCost();
        mType = type;
    }
}
