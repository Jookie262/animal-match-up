package com.example.animalmatchup.game;

import android.content.Context;

import com.example.animalmatchup.model.ScoreModel;

import java.util.ArrayList;

public class PopulateScore {

    Context context;
    ScoreDB scoreDB;
    ArrayList<ScoreModel> allScores;

    public PopulateScore(Context context){
        this.context = context;
        scoreDB = new ScoreDB(context);
        allScores = scoreDB.viewAllScores();
    }

    public ArrayList<ScoreModel> getHighestScore(){
        if (allScores.size() > 0) {
            // Get the highest score from the list
            ScoreModel highestScore = allScores.get(0);

            // Create a new ArrayList to hold the highest score
            ArrayList<ScoreModel> highestScoreList = new ArrayList<>();
            highestScoreList.add(highestScore);

            return highestScoreList;
        } else {
            // Return an empty ArrayList if there are no scores
            return new ArrayList<>();
        }
    }

    public ArrayList<ScoreModel> populateScore(){
        if (allScores.size() > 1) {
            // Select ArrayList from the second element onwards
            ArrayList<ScoreModel> selectedScores;
            if (allScores.size() >= 7) {
                selectedScores = new ArrayList<>(allScores.subList(1, 7)); // Select top 7 scores
            } else {
                selectedScores = new ArrayList<>(allScores.subList(1, allScores.size())); // Select remaining scores
            }
            return selectedScores;
        } else {
            // Return an empty ArrayList if there are no elements or only one element
            return new ArrayList<>();
        }
    }
}
