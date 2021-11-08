package com.example.homegym_remake;

public class RecItem {
    private int item_image;
    private String item_title;

    public RecItem(int item_image, String item_title) {
        this.item_image = item_image;
        this.item_title = item_title;
    }

    public String getItem_title() {
        return item_title;
    }
    public int getItem_image() {
        return item_image;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }
    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}

