package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, Window window) {
        window.drawWall(wall.getPosition());
    }
}