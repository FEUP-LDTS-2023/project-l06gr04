package org.example.model.game;
import java.util.ArrayList;
import java.util.List;

public class Score {
    private int score;
    private List<ScoreChangeListener> listeners;

    public Score() {
        this.score = 0;
        this.listeners = new ArrayList<>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        notifyListeners();
    }

    public void incrementScore(int points) {
        this.score += points;
        notifyListeners();
    }

    public void addScoreChangeListener(ScoreChangeListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (ScoreChangeListener listener : listeners) {
            listener.onScoreChanged(score);
        }
    }
}
