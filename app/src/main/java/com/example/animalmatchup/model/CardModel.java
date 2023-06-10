package com.example.animalmatchup.model;

import android.widget.ImageView;

public class CardModel {
    private String name;
    private int back_img;
    private int front_img;

    public CardModel(String name, int back_img, int front_img) {
        this.name = name;
        this.back_img = back_img;
        this.front_img = front_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBack_img() {
        return back_img;
    }

    public void setBack_img(int back_img) {
        this.back_img = back_img;
    }

    public int getFront_img() {
        return front_img;
    }

    public void setFront_img(int img) {
        this.front_img = img;
    }
}
