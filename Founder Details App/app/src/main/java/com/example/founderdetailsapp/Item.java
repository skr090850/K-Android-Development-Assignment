package com.example.founderdetailsapp;

public class Item {
    private int image;
    private String title;

    public Item(int image, String title) {
        this.image = image;
        this.title = title;
    }
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
