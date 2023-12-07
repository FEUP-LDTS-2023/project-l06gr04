package org.example.model.game;


import org.example.model.game.level.LevelModel;

public interface LevelChangeListener {
    void onLevelChanged(LevelModel levelModel);
}
