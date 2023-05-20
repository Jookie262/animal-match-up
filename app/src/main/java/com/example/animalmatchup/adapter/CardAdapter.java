package com.example.animalmatchup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.animalmatchup.R;
import com.example.animalmatchup.model.CardModel;

import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter<CardModel> {

    public CardAdapter(@NonNull Context context, ArrayList<CardModel> cardModels) {
        super(context, 0, cardModels);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CardHolder cardHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, parent, false);
            cardHolder = new CardHolder(convertView);
            convertView.setTag(cardHolder);
        } else {
            cardHolder = (CardHolder) convertView.getTag();
        }

        CardModel model = getItem(position);
        cardHolder.getBackImage().setImageResource(model.getBack_img());
        cardHolder.getFrontImage().setImageResource(model.getImg());
        return convertView;
    }
}
