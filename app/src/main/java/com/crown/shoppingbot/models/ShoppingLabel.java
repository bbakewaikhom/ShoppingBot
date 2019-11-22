package com.crown.shoppingbot.models;

public class ShoppingLabel extends ListItem{
    private String lable;

    public ShoppingLabel(String lable) {
        this.lable = lable;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_LABEL;
    }
}
