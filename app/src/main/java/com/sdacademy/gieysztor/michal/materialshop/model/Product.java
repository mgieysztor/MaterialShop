package com.sdacademy.gieysztor.michal.materialshop.model;

/**
 * Created by RENT on 2017-02-18.
 */

public class Product {

    private final int mId;
    private String mName;
    private double mPrice;
    private int mImageResId;

    public Product(int mId, String mName, double mPrice, int mImageResId) {
        this.mId = mId;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mImageResId = mImageResId;
    }

    public int getmId() {
        return mId;
    }

    public String getmName() {
        return mName;
    }

    public double getmPrice() {
        return mPrice;
    }

    public int getmImageResId() {
        return mImageResId;
    }
}
