package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.game.elements.Wall;
import org.example.viewer.Viewer;

public class WallViewer extends Viewer<Wall> {

    public WallViewer(Wall wall) {
        super(wall);
    }

    @Override
    protected void drawElements(Window window) {
        Wall wall = getModel();
        Position position = wall.getPosition();
        window.drawWall(position);
    }
}