package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Skeleton;

public class EnemyViewer implements ElementViewer<Enemy> {

    private final Enemy enemy;

    public EnemyViewer(Enemy enemy) {
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Character getEnemySymbol() {
        if (enemy instanceof Golem) {
            return 'G';
        } else if (enemy instanceof Skeleton) {
            return 'S';
        } else {
            return 'O';
        }
    }

    @Override
    public void draw(Enemy element, Window window) {
        Position position = enemy.getPosition();
        Character enemySymbol = getEnemySymbol();
        window.drawEnemy(position, enemySymbol);
    }
}