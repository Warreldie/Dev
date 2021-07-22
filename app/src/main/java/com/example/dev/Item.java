package com.example.dev;

public class Item {
    private String mTitle;
    private String mText;
    private String mDetailTitle;

    public Item(String title, String text) {
        mTitle = title;
        mText = text;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getText(){ return mText; }
}
