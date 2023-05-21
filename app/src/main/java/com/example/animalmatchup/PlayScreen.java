package com.example.animalmatchup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.animalmatchup.model.GameModel;
import com.example.animalmatchup.play.RoundOne;

public class PlayScreen extends AppCompatActivity {

    GameModel gameModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        gameModel = new GameModel();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RoundOne(gameModel)).commit();
    }
}