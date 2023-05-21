package com.example.animalmatchup.play;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animalmatchup.PlayScreen;
import com.example.animalmatchup.R;
import com.example.animalmatchup.model.GameModel;

public class CongratsScreen extends Fragment {
    ImageView backBtn, nextLevelBtn;
    TextView finalScore;
    GameModel gameModel;
    String fragment_round_num;

    public CongratsScreen(GameModel gameModel, String fragment_round_num){
        this.gameModel = gameModel;
        this.fragment_round_num = fragment_round_num;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_congrats_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backBtn = view.findViewById(R.id.back_btn);
        nextLevelBtn = view.findViewById(R.id.next_level_btn);
        finalScore = view.findViewById(R.id.final_score);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        if(fragment_round_num.equals("Round 1")){
            finalScore.setText(null);
            nextLevelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new RoundTwo(gameModel)).commit();
                }
            });
        } else if(fragment_round_num.equals("Round 2")){
            finalScore.setText("Final Score: " + String.valueOf(gameModel.getScore()));
            nextLevelBtn.setImageResource(R.drawable.play_again_btn);

            nextLevelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                    getActivity().startActivity(new Intent(getContext(), PlayScreen.class));
                }
            });
        }
    }
}