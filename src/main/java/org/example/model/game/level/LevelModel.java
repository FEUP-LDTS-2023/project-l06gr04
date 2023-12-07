package org.example.model.game.level;

import org.example.model.game.LevelChangeListener;

import java.util.ArrayList;
import java.util.List;

public class LevelModel {
    private int level;
    private int scoreThreshold;
    private List<LevelChangeListener> listeners;

    public LevelModel() {
        this.level = 1;
        this.scoreThreshold = 1000;
        this.listeners = new ArrayList<>();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyListeners();
    }

    public int getScoreThreshold() {
        return scoreThreshold;
    }

    public void setScoreThreshold(int scoreThreshold) {
        this.scoreThreshold = scoreThreshold;
        notifyListeners();
    }

    public void addLevelChangeListener(LevelChangeListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (LevelChangeListener listener : listeners) {
            listener.onLevelChanged(this); // Passa o LevelModel como argumento
        }
    }

    public void updateLevel(int newScore) {
        if (newScore >= scoreThreshold) {
            level++;
            scoreThreshold += 1000;
            notifyListeners();
        }
    }
}
