package com.example.dev;
//Get's the items
public class Item {
    private String mTitle;
    private String mText;

    public Item(String title, String text) {
        mTitle = title;
        mText = text;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getText(){ return mText; }
}
