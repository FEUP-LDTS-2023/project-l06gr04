package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.Score;

public class ScoreViewer {
    public void draw(Score score, Window window) {
        String scoreString = Integer.toString(score.getScore());
        window.drawScore("Score: " + scoreString);
    }
}