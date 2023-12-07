package org.example.viewer.game;

import org.example.model.game.ScoreChangeListener;

public class ScoreViewer implements ScoreChangeListener {
    public void displayScore(int score) {
        System.out.println("Score: " + score);
    }

    @Override
    public void onScoreChanged(int newScore) {
        displayScore(newScore);
    }
}
