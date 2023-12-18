package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;
import org.example.model.game.Score;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreController extends GameController {
    private final Score scoreModel;
    private Level level;
    private long lastMovement;

    public ScoreController(Arena arena, Score scoreModel) {
        super(arena);
        this.scoreModel = scoreModel;
        this.level = new Level();
        this.lastMovement = 0;
    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 50) {
            updateScore();
            level.updateLevel(scoreModel);
            this.lastMovement = time;
        }
    }
    private void updateScore() {
        List<Enemy> enemies = getModel().getEnemies();

        for (Enemy enemy : enemies) {
            if (enemy.isDead()) {
                switch (enemy.getEnemySymbol()) {
                    case 'S':
                        scoreModel.incrementScore(10 + level.getLevel() * 2);
                        getModel().setCoins(getModel().getCoins() + 25);

                        break;
                    case 'O':
                        scoreModel.incrementScore(20 + level.getLevel() * 2);
                        getModel().setCoins(getModel().getCoins() + 50);

                        break;
                    case 'G':
                        scoreModel.incrementScore(50 + level.getLevel() * 3);
                        getModel().setCoins(getModel().getCoins() + 100);

                        break;
                }


            }
        }

    }
}