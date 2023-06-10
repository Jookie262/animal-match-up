package com.example.animalmatchup.play;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animalmatchup.R;
import com.example.animalmatchup.adapter.CardAdapter;
import com.example.animalmatchup.model.GameModel;
import com.example.animalmatchup.model.PopulateCard;

public class RoundTwo extends Fragment {

    RecyclerView recyclerView;
    GameModel gameModel;
    TextView gameScore, animScore;
    ImageView backBtn, infoBtn;

    public RoundTwo(GameModel gameModel){
        this.gameModel = gameModel;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_round_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.animals_card);
        gameScore = view.findViewById(R.id.game_score);
        infoBtn = view.findViewById(R.id.info_btn);
        backBtn = view.findViewById(R.id.back_btn);
        animScore = view.findViewById(R.id.anim_score);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        PopulateCard populateCard = new PopulateCard();
        CardAdapter cardAdapter = new CardAdapter(populateCard.populateCard(), getContext(), gameModel, gameScore, animScore, populateCard.getTotalAnimals(), getFragmentManager(), "Round 2");
        recyclerView.setAdapter(cardAdapter);
        gameScore.setText(String.valueOf(gameModel.getScore()));

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