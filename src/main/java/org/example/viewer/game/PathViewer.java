package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.game.elements.Path;

public class PathViewer implements ElementViewer<Path> {
    private Path path;

    public PathViewer(Path path) {
        this.path = path;
    }

    @Override
    public void draw(Path path, Window window) {
        for (int col = 0; col < 120; col++) {
            for (int row = 0; row < 40; row++) {
                if (path.isPath(new Position(col, row))) {
                    window.drawPath(new Position(col, row));
                }
            }
        }
    }
}