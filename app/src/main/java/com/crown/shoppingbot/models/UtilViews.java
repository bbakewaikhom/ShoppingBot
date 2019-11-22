package com.crown.shoppingbot.models;

public class UtilViews extends ListItem{
    private final int type;

    public UtilViews(int type) {
        this.type = type;
    }

    @Override
    public int getType() {
        return this.type;
    }
}
