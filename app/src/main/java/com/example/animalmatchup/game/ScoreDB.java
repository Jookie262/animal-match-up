package com.example.animalmatchup.game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.animalmatchup.model.ScoreModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ScoreDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_SCORES = "scores";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SCORE = "score";

    public ScoreDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_SCORES +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SCORE + " TEXT" +
                ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        onCreate(db);
    }

    public void addScore(String name, String score) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SCORE, score);
        db.insert(TABLE_SCORES, null, values);
        db.close();
    }

    public ArrayList<ScoreModel> viewAllScores() {
        ArrayList<ScoreModel> scores = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SCORES, null);

        int idIndex = cursor.getColumnIndex(COLUMN_ID);
        int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
        int scoreIndex = cursor.getColumnIndex(COLUMN_SCORE);

        while (cursor.moveToNext()) {
            if (idIndex >= 0 && nameIndex >= 0 && scoreIndex >= 0) {
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                String score = cursor.getString(scoreIndex);
                ScoreModel scoreModel = new ScoreModel(id, Integer.parseInt(score), name);
                scores.add(scoreModel);
            }
        }

        cursor.close();
        db.close();

        // Sort the scores in descending order based on the score value
        // If the scores are the same, compare the IDs in descending order
        Collections.sort(scores, new Comparator<ScoreModel>() {
            @Override
            public int compare(ScoreModel score1, ScoreModel score2) {
                int scoreComparison = Integer.compare(score2.getScore(), score1.getScore());
                if (scoreComparison == 0) {
                    return Integer.compare(score2.getId(), score1.getId());
                }
                return scoreComparison;
            }
        });

        return scores;
    }

}
