package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.Level;



public class LevelViewer {

    public void draw(Level level, Window window) {
        String levelString = Integer.toString(level.getLevel());
        window.drawLevel("Level: " + levelString);
    }
}
