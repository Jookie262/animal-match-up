package com.example.animalmatchup.adapter;

import android.view.View;
import android.widget.ImageView;

import com.example.animalmatchup.R;

public class CardHolder {
    private final ImageView backImage;
    private final ImageView frontImage;

    public CardHolder(View view) {
        backImage = view.findViewById(R.id.back_img);
        frontImage = view.findViewById(R.id.front_img);
    }

    public ImageView getBackImage() {
        return backImage;
    }

    public ImageView getFrontImage() {
        return frontImage;
    }
}
