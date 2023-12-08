package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;
import org.example.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(Window window) {
        drawElements(window, getModel().getWalls(), new WallViewer());
        drawElements(window, getModel().getPaths(), new PathViewer());
        Chest chest = (Chest) getModel().getChest();
        drawElement(window, chest, new ChestViewer());
        List<Enemy> enemies = getModel().getEnemies();
        if (enemies != null && !enemies.isEmpty()) {
            EnemyViewer enemyViewer = new EnemyViewer();
            for (Enemy enemy : enemies) {
                drawElement(window, enemy, enemyViewer);
            }
        }

        List<Tower> towers = getModel().getTowers();
        if (towers != null && !towers.isEmpty()) {
            TowerViewer towerViewer = new TowerViewer();
            for (Tower tower : towers) {
                drawElement(window, tower, towerViewer);
            }
        }
        //window.drawText(new Position(0, 0), "LIFE " + getModel().getTowers()/*dar a vida*/, "#FFD700");
    }

    private <T extends Element> void drawElements(Window window, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(window, element, viewer);
    }

    private <T extends Element> void drawElement(Window window, T element, ElementViewer<T> viewer) {
        viewer.draw(element, window);
    }
}