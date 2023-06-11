package com.example.animalmatchup.adapter.scoreadapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalmatchup.R;

public class ScoreHolder extends RecyclerView.ViewHolder {
    private TextView rank, name, score;

    public ScoreHolder(@NonNull View itemView) {
        super(itemView);
        rank = itemView.findViewById(R.id.rank_txt);
        name = itemView.findViewById(R.id.name_txt);
        score = itemView.findViewById(R.id.score_txt);
    }

    public TextView getRank() {
        return rank;
    }


    public TextView getName() {
        return name;
    }

    public TextView getScore() {
        return score;
    }

}
