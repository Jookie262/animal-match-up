package com.example.animalmatchup.play;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
    ImageView backBtn, nextLevelBtn, infoBtn;
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
        infoBtn = view.findViewById(R.id.info_btn);
        finalScore = view.findViewById(R.id.final_score);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoBox();
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

    private void infoBox(){
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        // Set the message show for the Alert time
        builder.setMessage("A Task Performance in Mobile App that aims to develop a simple mobile game like Memory Game");

        // Set Alert Title
        builder.setTitle("Animal Match Up");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            // When the user click yes button then app will close
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
}