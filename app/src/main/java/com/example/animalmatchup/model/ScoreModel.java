package com.example.animalmatchup.model;

public class ScoreModel {

    private int id;
    private int score;
    private String name;

    public ScoreModel(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public ScoreModel(int id, int score, String name) {
        this.id = id;
        this.score = score;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
