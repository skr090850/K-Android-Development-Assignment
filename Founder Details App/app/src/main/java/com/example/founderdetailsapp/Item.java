package com.example.founderdetailsapp;

public class Item {
    private int image;
    private String title;
    private String decs;

    public Item(int image, String title, String decs) {
        this.image = image;
        this.title = title;
        this.decs = decs;
    }
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
    public String getDecs(){
        return decs;
    }
}
