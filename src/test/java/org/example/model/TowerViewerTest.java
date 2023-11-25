package org.example.model;

import org.example.gui.Window;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.CanonTower;
import org.example.model.game.elements.towers.MageTower;
import org.example.model.game.elements.towers.Tower;
import org.example.viewer.game.TowerViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TowerViewerTest {
    private Window window;

    private Tower tower;

    @Test
    public void draw_shouldDrawTowerSymbolAtPosition() {
        Window window = mock(Window.class);

        Tower[] towers = new Tower[3];

        ArcherTower archerTower = new ArcherTower(1, 1);
        towers[0] = archerTower;

        MageTower mageTower = new MageTower(2, 2);
        towers[1] = mageTower;

        CanonTower canonTower = new CanonTower(3, 3);
        towers[2] = canonTower;

        for (Tower tower : towers) {
            TowerViewer towerViewer = new TowerViewer(tower);
            towerViewer.draw(tower, window);
        }

        verify(window).drawTower(eq(archerTower.getPosition()), eq('A'));
        verify(window).drawTower(eq(mageTower.getPosition()), eq('M'));
        verify(window).drawTower(eq(canonTower.getPosition()), eq('C'));
    }

}
