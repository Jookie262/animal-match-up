package com.example.animalmatchup.adapter.scoreadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalmatchup.R;
import com.example.animalmatchup.adapter.gameadapter.CardHolder;
import com.example.animalmatchup.model.ScoreModel;

import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreHolder> {
    private ArrayList<ScoreModel> scoreModels;

    public ScoreAdapter(ArrayList<ScoreModel> scoreModels){
        this.scoreModels = scoreModels;
    }

    @NonNull
    @Override
    public ScoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_card, parent, false);
        return new ScoreHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreHolder holder, int position) {
        ScoreModel scoreModel = scoreModels.get(position);
        holder.getName().setText(scoreModel.getName());
        holder.getScore().setText(String.valueOf(scoreModel.getScore()));
        holder.getRank().setText(String.valueOf(position + 2));
    }

    @Override
    public int getItemCount() {
        return scoreModels.size();
    }
}
