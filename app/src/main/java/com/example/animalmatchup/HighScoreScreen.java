package com.example.animalmatchup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animalmatchup.adapter.scoreadapter.ScoreAdapter;
import com.example.animalmatchup.game.InfoBox;
import com.example.animalmatchup.game.PopulateScore;
import com.example.animalmatchup.model.ScoreModel;

import java.util.ArrayList;

public class HighScoreScreen extends AppCompatActivity {
    ImageView backBtn, infoBtn;
    TextView highest_score_txt, highest_score_name_txt;
    RecyclerView score_view;
    InfoBox infoBox;
    PopulateScore populateScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_screen);
        init();
        clickBackInfo();
        scoreRecyclerView();
        changeHighestScore();
    }

    public void init(){
        backBtn = findViewById(R.id.back_btn);
        infoBtn = findViewById(R.id.info_btn);
        infoBox = new InfoBox();
        highest_score_txt = findViewById(R.id.highest_score_txt);
        highest_score_name_txt = findViewById(R.id.highest_score_name_txt);
        score_view = findViewById(R.id.score_view);
        populateScore = new PopulateScore(getApplicationContext());
    }

    public void clickBackInfo(){
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoBox.infoBox(HighScoreScreen.this);
            }
        });
    }

    public void changeHighestScore(){
        ArrayList<ScoreModel> highestScores = populateScore.getHighestScore();
        if (!highestScores.isEmpty()) {
            ScoreModel highestScore = highestScores.get(0);
            String highestScoreValue = String.valueOf(highestScore.getScore());
            String highestScoreName = highestScore.getName();
            highest_score_txt.setText(highestScoreValue);
            highest_score_name_txt.setText(highestScoreName);
        }
    }

    public void scoreRecyclerView(){
        PopulateScore populateScore = new PopulateScore(getApplicationContext());
        ScoreAdapter scoreAdapter = new ScoreAdapter(populateScore.populateScore());
        score_view.setLayoutManager(new GridLayoutManager(this, 1));
        score_view.setAdapter(scoreAdapter);
    }
}