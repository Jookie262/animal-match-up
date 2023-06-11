package com.example.animalmatchup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.animalmatchup.game.InfoBox;

public class WelcomeScreen extends AppCompatActivity {
    ImageButton playButton, highScoreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        playButton = findViewById(R.id.play_button);
        highScoreButton = findViewById(R.id.high_score_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeScreen.this, PlayScreen.class);
                startActivity(i);
            }
        });

        highScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeScreen.this, HighScoreScreen.class);
                startActivity(i);
            }
        });
    }
}