package edu.miracosta.cs112.swamis.model;

import java.util.Objects;

public abstract class Clothing extends Item {

    protected int mSex;

    public int getSex() {
        return mSex;
    }

    public void setSex(int sex) {
        mSex = sex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;
        return mSex == clothing.mSex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mSex);
    }

    protected Clothing(int sex) {
        mSex = sex;
    }
}
