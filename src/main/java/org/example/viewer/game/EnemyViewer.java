package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.enemys.Enemy;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, Window window) {
        window.drawEnemy(Enemy.getPosition());
    }
}
