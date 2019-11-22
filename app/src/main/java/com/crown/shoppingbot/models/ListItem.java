package com.crown.shoppingbot.models;

import android.os.Parcelable;

import java.util.ArrayList;

public abstract class ListItem extends ArrayList<Parcelable> {
    public static final int TYPE_LABEL = 0;
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_FOOTER = 2;

    abstract public int getType();
}
