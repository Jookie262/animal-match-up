package com.example.animalmatchup.adapter.gameadapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalmatchup.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

public class CardHolder  extends RecyclerView.ViewHolder{
    private final ImageView backImage;
    private final ImageView frontImage;
    private final EasyFlipView easyFlipView;

    public CardHolder(@NonNull View itemView) {
        super(itemView);
        backImage = itemView.findViewById(R.id.back_img);
        frontImage = itemView.findViewById(R.id.front_img);
        easyFlipView = itemView.findViewById(R.id.card_flip);
    }

    public ImageView getBackImage() {
        return backImage;
    }

    public ImageView getFrontImage() {
        return frontImage;
    }

    public EasyFlipView getEasyFlipView() {
        return easyFlipView;
    }
}
