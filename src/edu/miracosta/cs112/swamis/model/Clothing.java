package edu.miracosta.cs112.swamis.model;

import java.util.Objects;

public abstract class Clothing extends Item {

    protected String mSex;

    public String getSex() {
        return mSex;
    }

    public void setSex(String sex) {
        mSex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;
        return Objects.equals(mSex, clothing.mSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mSex);
    }

    public Clothing(String sex) {
        mSex = sex;
    }
}
