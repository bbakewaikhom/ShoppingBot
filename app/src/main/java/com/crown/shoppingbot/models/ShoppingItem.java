package com.crown.shoppingbot.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ShoppingItem extends ListItem implements Parcelable{
    private String name;
    private int block;

    public ShoppingItem(String name, int block) {
        this.name = name;
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_ITEM;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.block);
    }

    protected ShoppingItem(Parcel in) {
        this.name = in.readString();
        this.block = in.readInt();
    }

    public static final Parcelable.Creator<ShoppingItem> CREATOR = new Parcelable.Creator<ShoppingItem>() {
        @Override
        public ShoppingItem createFromParcel(Parcel source) {
            return new ShoppingItem(source);
        }

        @Override
        public ShoppingItem[] newArray(int size) {
            return new ShoppingItem[size];
        }
    };
}
