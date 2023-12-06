package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;

import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovement;

    public EnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Enemy enemy : getModel().getEnemies())
                moveMonster(enemy, enemy.getPosition()/*dar movivento aos enemys*/);
            this.lastMovement = time;
        }
    }

    private void moveMonster(Enemy monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            /*verificar se ele morre*/
        }
    }
}
