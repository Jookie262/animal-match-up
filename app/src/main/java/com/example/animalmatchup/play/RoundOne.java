package com.example.animalmatchup.play;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animalmatchup.R;
import com.example.animalmatchup.adapter.gameadapter.CardAdapter;
import com.example.animalmatchup.game.InfoBox;
import com.example.animalmatchup.model.GameModel;
import com.example.animalmatchup.game.PopulateCard;

public class RoundOne extends Fragment {

    RecyclerView recyclerView;
    GameModel gameModel;
    TextView gameScore, animScore;
    ImageView backBtn, infoBtn;
    InfoBox infoBox;

    public RoundOne(GameModel gameModel){
        this.gameModel = gameModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_round_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.animals_card);
        infoBtn = view.findViewById(R.id.info_btn);
        gameScore = view.findViewById(R.id.game_score);
        animScore = view.findViewById(R.id.anim_score);
        backBtn = view.findViewById(R.id.back_btn);
        infoBox = new InfoBox();
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        PopulateCard populateCard = new PopulateCard(3);
        CardAdapter cardAdapter = new CardAdapter(populateCard.populateCard(), getContext(), gameModel, gameScore, animScore, populateCard.getTotalAnimals(), getFragmentManager(), "Round 1");
        recyclerView.setAdapter(cardAdapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoBox.infoBox(getContext());
            }
        });
    }


}