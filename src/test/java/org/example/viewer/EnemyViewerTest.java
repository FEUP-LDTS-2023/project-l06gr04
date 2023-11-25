package org.example.viewer;

import org.example.gui.Window;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;
import org.example.viewer.game.EnemyViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EnemyViewerTest {

    @Mock
    private Window window;
    @Mock
    private Enemy enemy;

    @Test
    public void draw_shouldDrawEnemySymbolAtPosition() {
        Window window = mock(Window.class);

        Enemy[] enemies = new Enemy[3];

        Golem golem = new Golem(1, 1);
        enemies[0] = golem;

        Skeleton skeleton = new Skeleton(2, 2);
        enemies[1] = skeleton;

        Orc orc = new Orc(3, 3);
        enemies[2] = orc;

        for (Enemy enemy : enemies) {
            EnemyViewer enemyViewer = new EnemyViewer(enemy);
            enemyViewer.draw(enemy, window);
        }

        verify(window).drawEnemy(eq(golem.getPosition()), eq('G'));
        verify(window).drawEnemy(eq(skeleton.getPosition()), eq('S'));
        verify(window).drawEnemy(eq(orc.getPosition()), eq('O'));
    }
}
