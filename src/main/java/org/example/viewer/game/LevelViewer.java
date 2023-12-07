package org.example.viewer.game;


import org.example.model.game.LevelChangeListener;
import org.example.model.game.level.LevelModel;

public class LevelViewer implements LevelChangeListener {
    public void displayLevel(LevelModel level) {
        System.out.println("Level: " + level.getLevel());
    }

    @Override
    public void onLevelChanged(LevelModel newLevel) {
        displayLevel(newLevel);
    }
}
