package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.Wall;
import org.example.viewer.game.WallViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WallViewerTest {

    private Window window;

    private Wall wall;

    @Test
    public void draw_shouldDrawWallAtPosition() {
        Window window = mock(Window.class);

        Wall wall = new Wall(3, 3);

        WallViewer wallViewer = new WallViewer();
        wallViewer.draw(wall,window);

        verify(window).drawWall(eq(wall.getPosition()));
    }
}
