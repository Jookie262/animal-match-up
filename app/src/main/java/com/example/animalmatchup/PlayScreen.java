package com.example.animalmatchup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.animalmatchup.play.RoundOne;

public class PlayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RoundOne()).commit();
    }
}